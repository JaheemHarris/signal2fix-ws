package com.itu.signal2fixWS.repository;

import com.itu.signal2fixWS.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepo extends JpaRepository<Status,Long> {
}
