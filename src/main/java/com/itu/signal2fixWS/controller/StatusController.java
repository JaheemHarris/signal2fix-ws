package com.itu.signal2fixWS.controller;

import com.itu.signal2fixWS.model.Status;
import com.itu.signal2fixWS.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<?> getAllStatus(){
        return ResponseEntity.ok(statusService.getAllStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStatus(@PathVariable("id") Long id){
        return ResponseEntity.ok(statusService.getStatus(id));
    }

    @PostMapping
    public ResponseEntity<?> saveStatus(@RequestBody Status status){
        return ResponseEntity.ok(status);
    }
}
