package com.example.transit.controller;

import com.example.transit.model.Stop;
import com.example.transit.service.StopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stops")
@CrossOrigin(origins = "http://localhost:5173")
public class StopController {
    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping
    public List<Stop> getAllStops() {
        return stopService.getAllStops();
    }

    @GetMapping("/route/{routeId}")
    public List<Stop> getStopsByRoute(@PathVariable Long routeId) {
        return stopService.getStopsByRoute(routeId);
    }

    @GetMapping("/search")
    public List<Stop> searchStops(@RequestParam String keyword) {
        return stopService.searchStops(keyword);
    }

    @PostMapping
    public Stop createStop(@RequestBody Stop stop) {
        return stopService.saveStop(stop);
    }
}
