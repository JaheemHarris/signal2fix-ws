package com.itu.signal2fixWS.service;

import com.itu.signal2fixWS.model.TypeSignalement;
import com.itu.signal2fixWS.repository.TypeSignalementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeSignalementService {

    @Autowired
    private TypeSignalementRepo typeRepo;

    public TypeSignalement saveTypeSignalement(TypeSignalement typeSignalement){
        return typeRepo.save(typeSignalement);
    }

    public TypeSignalement getTypeSignalement(Long id){
        Optional<TypeSignalement> optType = typeRepo.findById(id);
        TypeSignalement typeSignalement = null;
        if(optType.isPresent())
            typeSignalement = optType.get();
        return  typeSignalement;
    }

    public List<TypeSignalement> getAllTypeSignalements(){
        return typeRepo.findAll();
    }
}
