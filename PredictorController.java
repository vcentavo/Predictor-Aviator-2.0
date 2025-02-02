package com.exemplo.aviatorpredictor.controller;

import com.exemplo.aviatorpredictor.model.Prediction;
import com.exemplo.aviatorpredictor.service.PredictorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PredictorController {

    @Autowired
    private PredictorService predictorService;

    @GetMapping("/predict")
    public Prediction predictNextNumber() {
        return predictorService.predict();
    }

    @GetMapping("/newflight")
    public String generateNewFlight() {
        predictorService.resetModel();
        return "Novo vôo gerado!";
    }
}
