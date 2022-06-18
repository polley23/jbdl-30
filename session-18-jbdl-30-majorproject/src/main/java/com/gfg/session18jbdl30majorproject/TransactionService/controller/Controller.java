package com.gfg.session18jbdl30majorproject.TransactionService.controller;

import com.gfg.session18jbdl30majorproject.TransactionService.entites.Transaction;
import com.gfg.session18jbdl30majorproject.TransactionService.manager.TransactionManager;
import com.gfg.session18jbdl30majorproject.TransactionService.models.TransactionRequest;
import com.gfg.session18jbdl30majorproject.TransactionService.models.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private TransactionManager transactionManager;

    @PostMapping("/transaction")
    ResponseEntity create(@RequestBody TransactionRequest transactionRequest){
       return ResponseEntity.ok(transactionManager.create(transactionRequest));
    }

    @GetMapping("/transaction/{transaction_id}")
    ResponseEntity get(@PathVariable("transaction_id") String transactionId){
        try {
            TransactionResponse transactionResponse =
                    transactionManager.get(transactionId);
            return ResponseEntity.ok(transactionResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PutMapping("/transaction/{transaction_id}/status/{ststud}")
//    ResponseEntity updateStatus(@PathVariable("transaction_id") String transactionId){
//        try {
//            TransactionResponse transactionResponse =
//                    transactionManager.get(transactionId);
//            return ResponseEntity.ok(transactionResponse);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
}
