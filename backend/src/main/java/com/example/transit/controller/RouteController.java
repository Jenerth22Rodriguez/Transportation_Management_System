package com.example.transit.controller;

import com.example.transit.model.Route;
import com.example.transit.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "http://localhost:5173")
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id);
    }

    @GetMapping("/search")
    public List<Route> searchRoutes(@RequestParam String keyword) {
        return routeService.searchRoutes(keyword);
    }

    @GetMapping("/best")
    public Route getBestRoute(@RequestParam double lat, @RequestParam double lng) {
        return routeService.findBestRoute(lat, lng);
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        return routeService.saveRoute(route);
    }

    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable Long id, @RequestBody Route route) {
        Route existingRoute = routeService.getRouteById(id);
        existingRoute.setRouteNumber(route.getRouteNumber());
        existingRoute.setRouteName(route.getRouteName());
        existingRoute.setStartLocation(route.getStartLocation());
        existingRoute.setEndLocation(route.getEndLocation());
        existingRoute.setOperatingHours(route.getOperatingHours());
        return routeService.saveRoute(existingRoute);
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
    }
}