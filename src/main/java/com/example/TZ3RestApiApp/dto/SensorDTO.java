package com.example.TZ3RestApiApp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

public class SensorDTO {
    @NotNull
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;

    public SensorDTO(String name) {
        this.name = name;
    }

    public SensorDTO() {

    }
    public String getName() {
        return name;
    }
}
