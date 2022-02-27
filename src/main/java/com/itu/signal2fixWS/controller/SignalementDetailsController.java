package com.itu.signal2fixWS.controller;

import com.itu.signal2fixWS.model.Region;
import com.itu.signal2fixWS.model.Role;
import com.itu.signal2fixWS.model.User;
import com.itu.signal2fixWS.service.SignalementDetailsService;
import com.itu.signal2fixWS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/signalementdetails")
public class SignalementDetailsController {

    @Autowired
    private SignalementDetailsService signalDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllSignalementsDetails(@PathVariable("id") Long id){
        return ResponseEntity.ok(signalDetailsService.getAllSignalDetails(id,null,null,null,null));
    }

    @GetMapping
    public ResponseEntity<?> getAllSignalementsDetails(@RequestParam(name="user",required = false) Long idUser, @RequestParam(name="region",required = false) Long idRegion, @RequestParam(name="type",required = false) Long idType, @RequestParam(name="status",required = false) Long idStatus, Principal principal){
        String userEmail = principal.getName();
        Optional<User> optUser = userService.getUserByMail(userEmail);
        if(optUser.isPresent()){
            User user = optUser.get();
            Role userRole = user.getRole();
            Region chiefRegion = user.getRegion();
            if(userRole.getNom().compareToIgnoreCase("USER")==0) {
                idUser = user.getId();
            }if(chiefRegion!=null){
                idRegion = chiefRegion.getId();
            }
        }
        return ResponseEntity.ok(signalDetailsService.getAllSignalDetails(null,idUser,idRegion,idType,idStatus));
    }
}
