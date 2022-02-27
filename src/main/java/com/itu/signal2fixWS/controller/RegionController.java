package com.itu.signal2fixWS.controller;

import com.itu.signal2fixWS.model.Region;
import com.itu.signal2fixWS.service.RegionService;
import com.itu.signal2fixWS.service.SignalementDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private SignalementDetailsService signalDetailsService;

    @GetMapping
    public ResponseEntity<?> getAllRegions(){
        List<Region> allRegions = regionService.getRegions();
        return ResponseEntity.ok(allRegions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRegion(@PathVariable("id") Long id){
        return ResponseEntity.ok(regionService.getRegion(id));
    }

    @PostMapping
    public ResponseEntity<?> saveRegion(@RequestBody Region region){
        return ResponseEntity.ok().body(region);
    }

    @GetMapping("/{id}/signalementdetails")
    public ResponseEntity<?> getRegionAllSignalement(@PathVariable("id") Long id,@RequestParam(name="type",required = false) Long idType,@RequestParam(name="status",required = false) Long idStatus){
        return ResponseEntity.ok().body(signalDetailsService.getAllSignalDetails(null,null,id,idType,idStatus));
    }

    @GetMapping("/{id}/signalementdetails/{idsignal}")
    public ResponseEntity<?> getRegionAllSignalement(@PathVariable("id") Long id,@PathVariable("idsignal") Long idSignal){
        return ResponseEntity.ok().body(signalDetailsService.getAllSignalDetails(idSignal,null,id,null,null));
    }
}
