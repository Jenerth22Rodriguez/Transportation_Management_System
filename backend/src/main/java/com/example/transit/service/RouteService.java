package com.example.transit.service;

import com.example.transit.model.Route;
import com.example.transit.model.Stop;
import com.example.transit.repository.RouteRepository;
import com.example.transit.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;

    public RouteService(RouteRepository routeRepository,
                        StopRepository stopRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route getRouteById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Route not found with id: " + id));
    }

    public List<Route> searchRoutes(String keyword) {
        return routeRepository
                .findByRouteNameContainingIgnoreCaseOrRouteNumberContainingIgnoreCase(
                        keyword,
                        keyword
                );
    }

    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    // NEW FEATURE:
    // Finds the closest route based on user location
    public Route findBestRoute(double userLat, double userLng) {

        List<Stop> stops = stopRepository.findAll();

        Stop closestStop = null;
        double shortestDistance = Double.MAX_VALUE;

        for (Stop stop : stops) {

            double distance = calculateDistance(
                    userLat,
                    userLng,
                    stop.getLatitude(),
                    stop.getLongitude()
            );

            if (distance < shortestDistance) {
                shortestDistance = distance;
                closestStop = stop;
            }
        }

        if (closestStop != null) {
            return closestStop.getRoute();
        }

        return null;
    }

    // Simple distance calculation
    private double calculateDistance(
            double lat1,
            double lng1,
            double lat2,
            double lng2
    ) {

        return Math.sqrt(
                Math.pow(lat1 - lat2, 2) +
                Math.pow(lng1 - lng2, 2)
        );
    }
}