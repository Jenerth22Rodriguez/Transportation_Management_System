package com.example.transit.controller;

import com.example.transit.model.Schedule;
import com.example.transit.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@CrossOrigin(origins = "http://localhost:5173")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/route/{routeId}")
    public List<Schedule> getSchedulesByRoute(@PathVariable Long routeId) {
        return scheduleService.getSchedulesByRoute(routeId);
    }

    @GetMapping("/stop/{stopId}")
    public List<Schedule> getSchedulesByStop(@PathVariable Long stopId) {
        return scheduleService.getSchedulesByStop(stopId);
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }
}
