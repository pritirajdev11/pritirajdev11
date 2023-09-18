package com.example.manageplan.model;

import org.springframework.data.domain.Page;

public class VideoPlanPaginationResponse {
    private Page<VideoPlan> content;
    private long totalElements;

    public VideoPlanPaginationResponse(Page<VideoPlan> content, long totalElements) {
        this.content = content;
        this.totalElements = totalElements;
    }

    public Page<VideoPlan> getContent() {
        return content;
    }

    public long getTotalElements() {
        return totalElements;
    }
}
