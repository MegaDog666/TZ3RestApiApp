package com.example.TZ3RestApiApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
public class Measurement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @Min(value = -100, message = "Value should be greater than -100")
    @Max(value = 100, message = "Value should be less than 100")
    @NotNull
    private double value;

    @Column(name = "raining")
    @NotNull
    private boolean raining;

    @OneToOne
    @JoinColumn(name = "sensor_id")
    @NotNull
    private Sensor sensor;

    @Column(name = "timestamp")
    private LocalDateTime createTime;

    public Measurement(double value, boolean raining, Sensor sensor, LocalDateTime createTime) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
        this.createTime = createTime;
    }

    public Measurement() {

    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
