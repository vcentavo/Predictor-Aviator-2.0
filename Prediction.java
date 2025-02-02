package com.exemplo.aviatorpredictor.model;

public class Prediction {
    private double predictedNumber;

    public Prediction(double predictedNumber) {
        this.predictedNumber = predictedNumber;
    }

    public double getPredictedNumber() {
        return predictedNumber;
    }

    public void setPredictedNumber(double predictedNumber) {
        this.predictedNumber = predictedNumber;
    }
}
