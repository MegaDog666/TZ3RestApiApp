package com.example.TZ3RestApiApp.client;

import com.example.TZ3RestApiApp.dto.MeasurementDTO;
import com.example.TZ3RestApiApp.dto.SensorDTO;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class PostClient {
    public static void main(String[] args) {
        Random random = new Random();
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 1000; i++) {
            restTemplate.postForEntity("http://localhost:8080/measurements/add",
                    new MeasurementDTO(random.nextFloat(),
                    random.nextBoolean(), new SensorDTO("Sensor Name")), Void.class);
        }
    }
}
