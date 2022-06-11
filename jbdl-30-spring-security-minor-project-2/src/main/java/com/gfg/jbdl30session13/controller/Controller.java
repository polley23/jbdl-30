package com.gfg.jbdl30session13.controller;

import com.gfg.jbdl30session13.entity.Employee;
import com.gfg.jbdl30session13.entity.EmployeeRequest;
import com.gfg.jbdl30session13.entity.User;
import com.gfg.jbdl30session13.manager.EmployeeManager;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


/*
Maintain employee records
Roles : Admin, HR, Manager Employee

- Employee basic details
    - ADD/Update -> HR
    - View -> ALL
- Employee Rating
    - ADD/Update -> HR/Manager of the employee
    - View -> HR, Manager of the employee and employee himself
- Employee Salary
 - ADD/Update -> HR
 - View -> HR, Manager of the employee and employee himself

*/
@RestController
public class Controller {
    @Autowired
    private EmployeeManager manager;
    @PostMapping("/employee")
    @PreAuthorize(value = "hasAnyAuthority('Admin','HR')")
    void createEmployee(@RequestBody  EmployeeRequest er){
        manager.createEmployee(er);
    }

    @PutMapping("/manager/{manager_id}/emp/{emp_id}")
    @PreAuthorize(value = "hasAnyAuthority('Admin','HR')")
    void addManager(@PathVariable("manager_id") String managerId,
                    @PathVariable("emp_id") String empId){
        manager.assignManager(managerId,empId);
    }

    @GetMapping("/emp/{emp_id}")
    @PreAuthorize(value = "isAuthenticated()")
    ResponseEntity getDetails(@PathVariable("emp_id") String empId, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        if( !user.getUsername().equals(empId) && !user.getRole().get(0).getRole().equals("HR")
         && !validateManagerSub( empId, user)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(manager.getEmployee(empId));

    }
    @PostMapping("/employee/{empId}/rating/{rating}")
    @PreAuthorize(value = "hasAnyAuthority('Admin','HR','MANAGER')")
    ResponseEntity postRating(@PathVariable("empId") String empId,
                    @PathVariable("rating") Float rating,  Authentication authentication){
        User user = (User) authentication.getPrincipal();
        if(user.getRole().get(0).getRole().equals("MANAGER")){
            if(!validateManagerSub(empId,user)){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        manager.postRating(empId,rating, user.getUsername());
        return ResponseEntity.ok().build();
    }
    private boolean validateManagerSub(String empId, User user) {
        if(user.getRole().get(0).getRole().equals("MANAGER")){
           return manager.isSubordinate(user.getUsername(),empId);
        }
        return false;
    }


}
