package com.hng12.backend_task_1.controller;

import com.hng12.backend_task_1.model.NumberClassificationResponse;
import com.hng12.backend_task_1.service.NumberClassificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class NumberClassificationController {
    private final NumberClassificationService classificationService;

    public NumberClassificationController(NumberClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @GetMapping("/classify-number")
    public ResponseEntity<Object> classifyNumber(@RequestParam String number) {
        try {
            int num = Integer.parseInt(number);
            return ResponseEntity.ok(classificationService.classifyNumber(num));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(Map.of("number", number, "error", true));
        }
    }
}
