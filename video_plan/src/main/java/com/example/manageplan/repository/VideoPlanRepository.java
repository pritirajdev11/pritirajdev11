package com.example.manageplan.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.manageplan.model.VideoPlan;

public interface VideoPlanRepository extends JpaRepository<VideoPlan, Long> {

    Page<VideoPlan> findById(Long id, Pageable pageable);
    
}
