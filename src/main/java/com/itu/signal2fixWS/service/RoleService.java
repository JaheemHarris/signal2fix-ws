package com.itu.signal2fixWS.service;

import com.itu.signal2fixWS.model.Role;
import com.itu.signal2fixWS.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<Role> getRoles(){
        return roleRepo.findAll();
    }
}
