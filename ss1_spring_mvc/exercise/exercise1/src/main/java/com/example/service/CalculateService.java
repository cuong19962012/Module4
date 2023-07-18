package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {
    @Override
    public double calculate(double amount, double percent) {
        double result;
        result = amount * percent;
        return result;
    }
}
