package com.example.TZ3RestApiApp.services;

import com.example.TZ3RestApiApp.dto.MeasurementDTO;
import com.example.TZ3RestApiApp.models.Measurement;
import com.example.TZ3RestApiApp.models.Sensor;
import com.example.TZ3RestApiApp.repositories.MeasurementRepository;
import com.example.TZ3RestApiApp.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }
    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }
    public int countRainingMeasurements() {
        return measurementRepository.countRainingMeasurements();
    }

    @Transactional
    public Measurement save(Measurement measurement) {
        enrichMeasurement(measurement);
        return measurementRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement) {
        String sensorName = measurement.getSensor().getName();

        Sensor sensor = sensorRepository.findByName(sensorName)
                        .orElseThrow(() -> new RuntimeException("Sensor with name " + sensorName + " not found"));
        measurement.setSensor(sensor);
        measurement.setCreateTime(LocalDateTime.now());
    }
}
