package com.itu.signal2fixWS.controller;

import com.itu.signal2fixWS.model.User;
import com.itu.signal2fixWS.service.SignalementDetailsService;
import com.itu.signal2fixWS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SignalementDetailsService signalDetailsService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@ModelAttribute @Valid User user, BindingResult bdr){
        Pattern pattern = Pattern.compile(".*[çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ].*");
        Matcher matcher = pattern.matcher(user.getMotDePasse());
        try{
            if(matcher.matches())
                bdr.addError(new FieldError("user","password","Password must not contain accented characters."));
            if(userService.checkIfEmailTaken(user.getEmail()))
                bdr.addError(new FieldError("user","email","Email already used!"));
            if(bdr.hasErrors())
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(bdr.getFieldErrors());
            User savedUser = userService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @GetMapping("/{id}/signalementedetails")
    public ResponseEntity<?> getUserAllSignalementDetails(@PathVariable("id") Long id,@RequestParam(name="region",required = false) Long idRegion,@RequestParam(name="type",required = false) Long idType,@RequestParam(name="status",required = false) Long idStatus){
        return ResponseEntity.ok().body(signalDetailsService.getAllSignalDetails(null,id,idRegion,idType,idStatus));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@ModelAttribute @Valid User user, BindingResult bdr){
        Pattern pattern = Pattern.compile(".*[çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ].*");
        Matcher matcher = pattern.matcher(user.getMotDePasse());
        try{
            if(matcher.matches())
                bdr.addError(new FieldError("user","password","Password must not contain accented characters."));
            if(userService.checkIfEmailTaken(user.getEmail()))
                bdr.addError(new FieldError("user","email","Email already used!"));
            if(bdr.hasErrors())
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(bdr.getFieldErrors());
            User savedUser = userService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }
}
