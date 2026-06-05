package com.example.transit.repository;

import com.example.transit.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByRouteNameContainingIgnoreCaseOrRouteNumberContainingIgnoreCase(String routeName, String routeNumber);
}
