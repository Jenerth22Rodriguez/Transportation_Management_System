package com.example.transit.service;

import com.example.transit.model.Stop;
import com.example.transit.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopService {
    private final StopRepository stopRepository;

    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    public List<Stop> getAllStops() {
        return stopRepository.findAll();
    }

    public List<Stop> getStopsByRoute(Long routeId) {
        return stopRepository.findByRouteIdOrderByStopOrderAsc(routeId);
    }

    public List<Stop> searchStops(String keyword) {
        return stopRepository.findByStopNameContainingIgnoreCase(keyword);
    }

    public Stop saveStop(Stop stop) {
        return stopRepository.save(stop);
    }
}
