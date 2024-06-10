package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Discount;
import com.example.demo.model.Product;
import com.example.demo.model.PromotionRequest;
import com.example.demo.model.PromotionResponse;
@Service
public class PromotionService {
	public PromotionResponse getPromotions(PromotionRequest request) {
        List<Product> products = request.getProducts();
        int countA = 0, countB = 0, countC = 0, countD = 0;

        for (Product product : products) {
            switch (product.getId()) {
                case "A":
                    countA++;
                    break;
                case "B":
                    countB++;
                    break;
                case "C":
                    countC++;
                    break;
                case "D":
                    countD++;
                    break;
            }
        }

        List<Discount> discounts = new ArrayList<>();
        if (countA == 0) {
            if (countB + countC > 1) {
                discounts.add(new Discount("X", Math.min(countB + countC - 1, 1)));
            }
            if (countD > 0) {
                discounts.add(new Discount("X", Math.max(countB + countC, 1)));
            }
        } else {
            if (countB + countC > 0) {
                discounts.add(new Discount("X", countB + countC));
            }
            if (countD > 0) {
                discounts.add(new Discount("Y", 1));
            }
        }

        return new PromotionResponse(discounts);
    }
}

