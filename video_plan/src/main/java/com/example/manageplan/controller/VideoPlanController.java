package com.example.manageplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.manageplan.model.VideoPlan;
import com.example.manageplan.service.VideoPlanService;

import java.util.Optional;

@RestController
@RequestMapping("/api/videoplans")
public class VideoPlanController {
    private final VideoPlanService videoPlanService;

    @Autowired
    public VideoPlanController(VideoPlanService videoPlanService) {
        this.videoPlanService = videoPlanService;
    }

    @GetMapping
    public ResponseEntity<Page<VideoPlan>> getAllVideoPlans(Pageable pageable) {
        Page<VideoPlan> videoPlans = videoPlanService.getAllVideoPlans(pageable);
        return ResponseEntity.ok(videoPlans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoPlan> getVideoPlanById(@PathVariable Long id) {
        Optional<VideoPlan> videoPlan = videoPlanService.getVideoPlanById(id);
        return videoPlan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    

    @GetMapping("/search/{id}")
    public ResponseEntity<Page<VideoPlan>> searchVideoPlansById(@PathVariable Long id, Pageable pageable) {
        Page<VideoPlan> videoPlans = videoPlanService.searchVideoPlansById(id, pageable);
        if (!videoPlans.isEmpty()) {
            return ResponseEntity.ok(videoPlans);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<VideoPlan> createVideoPlan(@RequestBody VideoPlan videoPlan) {
        VideoPlan createdVideoPlan = videoPlanService.createVideoPlan(videoPlan);
        return ResponseEntity.ok(createdVideoPlan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoPlan> updateVideoPlan(@PathVariable Long id, @RequestBody VideoPlan updatedVideoPlan) {
        VideoPlan videoPlan = videoPlanService.updateVideoPlan(id, updatedVideoPlan);
        if (videoPlan != null) {
            return ResponseEntity.ok(videoPlan);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideoPlan(@PathVariable Long id) {
        boolean isDeleted = videoPlanService.deleteVideoPlan(id);
        if (isDeleted) {
            return ResponseEntity.ok("Video deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video not found");
        }
    }
}
