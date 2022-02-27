package com.itu.signal2fixWS.service;

import com.itu.signal2fixWS.model.Signalement;
import com.itu.signal2fixWS.repository.SignalementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.Signal;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SignalementService {

    @Autowired
    private SignalementRepo signalRepo;

    public List<Signalement> getAllSignalements(){
        return  signalRepo.findAll();
    }

    public Signalement saveSignalement(Signalement signalement){
        return signalRepo.save(signalement);
    }

    public Signalement getSignalement(Long id){
        Optional<Signalement> optSignal = signalRepo.findById(id);
        Signalement signalement = null;
        if(optSignal.isPresent())
            signalement = optSignal.get();
        return signalement;
    }
}
