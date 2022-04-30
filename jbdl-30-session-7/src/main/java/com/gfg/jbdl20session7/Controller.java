package com.gfg.jbdl20session7;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    int salary;

    @PostMapping("/salary") // POST  http://localhost:8080/salary
    void create(){
        salary = 1000;
    }

    @GetMapping("/salary") // GET  http://localhost:8080/salary
    int get(){
        return this.salary;
    }

    @PutMapping("/salary/{new_salary}") // PUT  http://localhost:8080/salary
    void update(@PathVariable("new_salary") int salary){
         this.salary=salary;
    }

    @DeleteMapping("/salary/") // DELETE  http://localhost:8080/salary
    void delete(){
        this.salary=0;
    }
}
