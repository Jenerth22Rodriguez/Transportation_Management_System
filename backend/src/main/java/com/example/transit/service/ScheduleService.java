package com.example.transit.service;

import com.example.transit.model.Schedule;
import com.example.transit.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getSchedulesByRoute(Long routeId) {
        return scheduleRepository.findByRouteId(routeId);
    }

    public List<Schedule> getSchedulesByStop(Long stopId) {
        return scheduleRepository.findByStopId(stopId);
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
}
