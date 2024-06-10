package com.example.demo.controller;

import com.example.demo.model.PromotionRequest;
import com.example.demo.model.PromotionResponse;
import com.example.demo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @PostMapping
    public PromotionResponse getPromotions(@RequestBody PromotionRequest request) {
        return promotionService.getPromotions(request);
    }
}