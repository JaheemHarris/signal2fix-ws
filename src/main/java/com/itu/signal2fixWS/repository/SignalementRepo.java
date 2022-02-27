package com.itu.signal2fixWS.repository;

import com.itu.signal2fixWS.model.Signalement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalementRepo extends JpaRepository<Signalement,Long> {
}
