package com.example.transit.repository;

import com.example.transit.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByRouteId(Long routeId);
    List<Schedule> findByStopId(Long stopId);
}
