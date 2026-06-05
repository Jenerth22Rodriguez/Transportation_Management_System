package com.example.transit.repository;

import com.example.transit.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StopRepository extends JpaRepository<Stop, Long> {
    List<Stop> findByRouteIdOrderByStopOrderAsc(Long routeId);
    List<Stop> findByStopNameContainingIgnoreCase(String stopName);
}
