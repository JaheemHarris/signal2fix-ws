package com.itu.signal2fixWS.service;

import com.itu.signal2fixWS.model.ImageSignalement;
import com.itu.signal2fixWS.repository.ImageSignalementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageSignalementService {

    @Autowired
    private ImageSignalementRepo imageRepo;

    public ImageSignalement saveImage(ImageSignalement imageSignalement){
        return imageRepo.save(imageSignalement);
    }
}
