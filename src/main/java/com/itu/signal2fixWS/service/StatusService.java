package com.itu.signal2fixWS.service;

import com.itu.signal2fixWS.model.Status;
import com.itu.signal2fixWS.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatusService {

    @Autowired
    private StatusRepo statusRepo;

    public Status saveStatus(Status status){
        return statusRepo.save(status);
    }

    public Status getStatus(Long id){
        Optional<Status> optStatus = statusRepo.findById(id);
        Status status = null;
        if(optStatus.isPresent())
            status = optStatus.get();
        return status;
    }

    public List<Status> getAllStatus(){
        return statusRepo.findAll();
    }
}
