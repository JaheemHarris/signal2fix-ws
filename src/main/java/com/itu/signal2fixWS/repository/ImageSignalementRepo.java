package com.itu.signal2fixWS.repository;


import com.itu.signal2fixWS.model.ImageSignalement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageSignalementRepo extends JpaRepository<ImageSignalement, Long> {
}
