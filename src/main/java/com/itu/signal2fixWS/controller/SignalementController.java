package com.itu.signal2fixWS.controller;

import com.itu.signal2fixWS.model.ImageSignalement;
import com.itu.signal2fixWS.model.Signalement;
import com.itu.signal2fixWS.model.User;
import com.itu.signal2fixWS.service.ImageSignalementService;
import com.itu.signal2fixWS.service.SignalementService;
import com.itu.signal2fixWS.service.UserService;
import com.itu.signal2fixWS.util.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/signalements")
public class SignalementController {

    @Autowired
    private SignalementService signalService;

    @Autowired
    private ImageSignalementService imageService;

    @Autowired
    private UserService userService;

    @Autowired
    private FileStorageService fileService;

    @GetMapping
    public ResponseEntity<?> getAllSignalements(){
        return ResponseEntity.ok(signalService.getAllSignalements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSignalement(@PathVariable("id") Long id){
        return ResponseEntity.ok(signalService.getSignalement(id));
    }

    @GetMapping("/image")
    public ResponseEntity<?> getSignalementImage(@RequestParam(name="fileName") String fileName){
        return ResponseEntity.ok(fileService.load(fileName));
    }

    @PostMapping
    public ResponseEntity<?> saveSignalement(@ModelAttribute Signalement signalement, @RequestParam(name="files",required = true) MultipartFile[] files, Authentication authentication){
        Optional<User> optUser = userService.getUserByMail(authentication.getName());
        if(optUser.isPresent()) {
            User currentUser = optUser.get();
            Long idUser = currentUser.getId();
            try{
                for(MultipartFile file : files){
                    ImageSignalement imageSignalement = fileService.save(file);
                    signalement.setIdUser(idUser);
                    Signalement savedSignalement = signalService.saveSignalement(signalement);
                    imageSignalement.setIdSignalement(savedSignalement.getId());
                    imageService.saveImage(imageSignalement);
                }
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
            }
        }else{
            return ResponseEntity.badRequest().body("Not user!");
        }
        return  ResponseEntity.ok().body(signalService.saveSignalement(signalement));
    }
}
