package com.hng12.backend_task_1.service;

import com.hng12.backend_task_1.model.NumberClassificationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberClassificationService {

    public NumberClassificationResponse classifyNumber(int num) {
        List<String> properties = new ArrayList<>();
        if (isArmstrong(num)) properties.add("armstrong");
        properties.add(num % 2 == 0 ? "even" : "odd");

        return new NumberClassificationResponse(num, isPrime(num), isPerfect(num), properties,
                String.valueOf(num).chars().map(Character::getNumericValue).sum(), getFunFact(num));
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private boolean isPerfect(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }
        }
        return sum == n && n != 1;
    }

    private boolean isArmstrong(int n) {
        int sum = 0, temp = n, digits = String.valueOf(n).length();
        while (temp > 0) {
            sum += Math.pow(temp % 10, digits);
            temp /= 10;
        }
        return sum == n;
    }

    private String getFunFact(int n) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://numbersapi.com/" + n + "/math?json";
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "No fun fact available.";
        }
    }
}
