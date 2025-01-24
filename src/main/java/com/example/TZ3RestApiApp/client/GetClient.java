package com.example.TZ3RestApiApp.client;

import com.example.TZ3RestApiApp.dto.SensorDTO;
import org.springframework.web.client.RestTemplate;

public class GetClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity("http://localhost:8080/measurements", Void.class);
    }
}
