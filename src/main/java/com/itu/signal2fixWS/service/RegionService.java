package com.itu.signal2fixWS.service;

import com.itu.signal2fixWS.model.Region;
import com.itu.signal2fixWS.repository.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RegionService {

    @Autowired
    private RegionRepo regionRepo;

    public Region saveRegion(Region region){
        return regionRepo.save(region);
    }

    public Region getRegion(Long id){
        Optional<Region> optRegion = regionRepo.findById(id);
        Region region = null;
        if(optRegion.isPresent())
            region = optRegion.get();

        return region;
    }

    public List<Region> getRegions(){
        return regionRepo.findAll();
    }
}
