package com.itu.signal2fixWS.service;

import com.itu.signal2fixWS.model.Role;
import com.itu.signal2fixWS.model.User;
import com.itu.signal2fixWS.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUser(Long id){
        Optional<User> optUser = userRepo.findById(id);
        User user = null;
        if(optUser.isPresent())
            user = optUser.get();
        return user;
    }

    public User saveUser(User user) throws Exception{
        if(this.getUserByMail(user.getEmail()).isPresent())
            throw new Exception("Email already used!");
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        user.setMotDePasse(bcrypt.encode(user.getMotDePasse()));
        return userRepo.save(user);
    }

    public User register(User user) throws Exception{
        if(this.getUserByMail(user.getEmail()).isPresent())
            throw new Exception("Email already used!");
        user.setRole(new Role(Long.valueOf(3),"USER"));
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        user.setMotDePasse(bcrypt.encode(user.getMotDePasse()));
        return userRepo.save(user);
    }

    public boolean checkIfEmailTaken(String email){
        if(this.getUserByMail(email).isPresent())
            return true;
        return false;
    }

    public Optional<User> getUserByMail(String email){
        return userRepo.findByEmail(email);
    }

}
