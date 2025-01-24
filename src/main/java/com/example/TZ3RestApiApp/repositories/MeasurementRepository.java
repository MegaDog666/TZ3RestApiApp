package com.example.TZ3RestApiApp.repositories;

import com.example.TZ3RestApiApp.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    @Query("SELECT Count(m) FROM Measurement m WHERE m.raining=true")
    int countRainingMeasurements();
}
