package com.itu.signal2fixWS.controller;

import com.itu.signal2fixWS.model.TypeSignalement;
import com.itu.signal2fixWS.service.TypeSignalementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/typesignalements")
public class TypeSignalementController {

    @Autowired
    private TypeSignalementService typeService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllTypes(){
        return ResponseEntity.ok().body(typeService.getAllTypeSignalements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getType(@PathVariable("id") Long id){
        return ResponseEntity.ok(typeService.getTypeSignalement(id));
    }

    @PostMapping
    public ResponseEntity<?> saveTypeSignalement(@RequestBody TypeSignalement typeSignalement){
        return ResponseEntity.ok(typeService.saveTypeSignalement(typeSignalement));
    }
}
