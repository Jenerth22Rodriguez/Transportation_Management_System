package com.example.transit;

import com.example.transit.model.Route;
import com.example.transit.model.Schedule;
import com.example.transit.model.Stop;
import com.example.transit.repository.RouteRepository;
import com.example.transit.repository.ScheduleRepository;
import com.example.transit.repository.StopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {
    private final RouteRepository routeRepository;
    private final StopRepository stopRepository;
    private final ScheduleRepository scheduleRepository;

    public DataLoader(RouteRepository routeRepository, StopRepository stopRepository, ScheduleRepository scheduleRepository) {
        this.routeRepository = routeRepository;
        this.stopRepository = stopRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void run(String... args) {
        if (routeRepository.count() == 0) {
            Route route1 = routeRepository.save(new Route("10", "Downtown Loop", "Central Station", "City Hall", "6:00 AM - 10:00 PM"));
            Route route2 = routeRepository.save(new Route("22", "East Side Express", "Mall Entrance", "University Campus", "5:30 AM - 11:00 PM"));
            Route route3 = routeRepository.save(new Route("35", "Airport Connector", "Downtown Station", "Louisville Airport", "5:00 AM - 11:30 PM"));
            Route route4 = routeRepository.save(new Route("48", "Riverfront Express", "Waterfront Park", "Museum District", "6:00 AM - 9:00 PM"));
            Route route5 = routeRepository.save(new Route("60", "East Market Route", "East End", "City Center", "5:30 AM - 10:30 PM"));

            Stop stop1 = stopRepository.save(new Stop("Central Station", "100 Main St", 38.2527, -85.7585, 1, route1));
            Stop stop2 = stopRepository.save(new Stop("Market Street", "220 Market St", 38.2540, -85.7550, 2, route1));
            Stop stop3 = stopRepository.save(new Stop("City Hall", "500 Civic Plaza", 38.2560, -85.7520, 3, route1));

            Stop stop4 = stopRepository.save(new Stop("Mall Entrance", "1 Shopping Center Dr", 38.2400, -85.7200, 1, route2));
            Stop stop5 = stopRepository.save(new Stop("University Campus", "900 College Ave", 38.2300, -85.7100, 2, route2));

            Stop stop6 = stopRepository.save(new Stop("Downtown Station", "300 Jefferson St", 38.2535, -85.7590, 1, route3));
            Stop stop7 = stopRepository.save(new Stop("Preston Highway", "1200 Preston Hwy", 38.2150, -85.7450, 2, route3));
            Stop stop8 = stopRepository.save(new Stop("Louisville Airport", "600 Terminal Dr", 38.1744, -85.7360, 3, route3));

            Stop stop9 = stopRepository.save(new Stop("Waterfront Park", "129 River Rd", 38.2590, -85.7440, 1, route4));
            Stop stop10 = stopRepository.save(new Stop("Main Street", "700 W Main St", 38.2570, -85.7620, 2, route4));
            Stop stop11 = stopRepository.save(new Stop("Museum District", "829 W Main St", 38.2575, -85.7645, 3, route4));

            Stop stop12 = stopRepository.save(new Stop("East End", "1000 Eastpoint Pkwy", 38.2860, -85.5600, 1, route5));
            Stop stop13 = stopRepository.save(new Stop("Brownsboro Road", "3900 Brownsboro Rd", 38.2830, -85.6600, 2, route5));
            Stop stop14 = stopRepository.save(new Stop("City Center", "400 S 4th St", 38.2490, -85.7570, 3, route5));

            scheduleRepository.save(new Schedule(route1.getId(), stop1.getId(), LocalTime.of(8, 0), "Weekday"));
            scheduleRepository.save(new Schedule(route1.getId(), stop2.getId(), LocalTime.of(8, 10), "Weekday"));
            scheduleRepository.save(new Schedule(route1.getId(), stop3.getId(), LocalTime.of(8, 20), "Weekday"));

            scheduleRepository.save(new Schedule(route2.getId(), stop4.getId(), LocalTime.of(8, 30), "Weekday"));
            scheduleRepository.save(new Schedule(route2.getId(), stop5.getId(), LocalTime.of(8, 45), "Weekday"));

            scheduleRepository.save(new Schedule(route3.getId(), stop6.getId(), LocalTime.of(9, 0), "Weekday"));
            scheduleRepository.save(new Schedule(route3.getId(), stop7.getId(), LocalTime.of(9, 15), "Weekday"));
            scheduleRepository.save(new Schedule(route3.getId(), stop8.getId(), LocalTime.of(9, 30), "Weekday"));

            scheduleRepository.save(new Schedule(route4.getId(), stop9.getId(), LocalTime.of(10, 0), "Weekday"));
            scheduleRepository.save(new Schedule(route4.getId(), stop10.getId(), LocalTime.of(10, 10), "Weekday"));
            scheduleRepository.save(new Schedule(route4.getId(), stop11.getId(), LocalTime.of(10, 20), "Weekday"));

            scheduleRepository.save(new Schedule(route5.getId(), stop12.getId(), LocalTime.of(11, 0), "Weekday"));
            scheduleRepository.save(new Schedule(route5.getId(), stop13.getId(), LocalTime.of(11, 20), "Weekday"));
            scheduleRepository.save(new Schedule(route5.getId(), stop14.getId(), LocalTime.of(11, 40), "Weekday"));
        }
    }
}