package com.itu.signal2fixWS.service;

import com.itu.signal2fixWS.model.SignalementDetails;
import com.itu.signal2fixWS.repository.SignalementDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalementDetailsService {

    @Autowired
    private SignalementDetailsRepo signalDetailsRepo;

    public List<SignalementDetails> getAllSignalDetails(Long idSignal,Long idUser,Long idRegion,Long idType,Long idStatus){
        return signalDetailsRepo.getSignalements(idSignal,idUser,idRegion,idType,idStatus);
    }
}
