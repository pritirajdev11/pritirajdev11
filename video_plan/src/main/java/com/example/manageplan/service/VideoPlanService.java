package com.example.manageplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manageplan.model.VideoPlan;
import com.example.manageplan.repository.VideoPlanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Service
public class VideoPlanService {
    private final VideoPlanRepository videoPlanRepository;

    @Autowired
    public VideoPlanService(VideoPlanRepository videoPlanRepository) {
        this.videoPlanRepository = videoPlanRepository;
    }


    public Page<VideoPlan> getAllVideoPlans(Pageable pageable) {
        return videoPlanRepository.findAll(pageable);
    }

    public Optional<VideoPlan> getVideoPlanById(Long id) {
        return videoPlanRepository.findById(id);
    }

    public VideoPlan createVideoPlan(VideoPlan videoPlan) {
        return videoPlanRepository.save(videoPlan);
    }

    public VideoPlan updateVideoPlan(Long id, VideoPlan updatedVideoPlan) {
        Optional<VideoPlan> existingVideoPlan = videoPlanRepository.findById(id);
        if (existingVideoPlan.isPresent()) {
            updatedVideoPlan.setId(id);
            return videoPlanRepository.save(updatedVideoPlan);
        }
        return null; 
    }

    public boolean deleteVideoPlan(Long id) {
        if (videoPlanRepository.existsById(id)) {
            videoPlanRepository.deleteById(id);
            return true; 
        }
        return false; 
    }

    public Page<VideoPlan> searchVideoPlansById(Long id, Pageable pageable) {
        Optional<VideoPlan> videoPlan = videoPlanRepository.findById(id);
        if (videoPlan.isPresent()) {
      
            pageable = PageRequest.of(pageable.getPageNumber(), 5);
            return videoPlanRepository.findById(id, pageable);
        } else {
            return Page.empty();
        }
    }

	public Page<VideoPlan> getVideoPlansByVideoId(Long videoId, PageRequest of) {
		return null;
	}
	
}
