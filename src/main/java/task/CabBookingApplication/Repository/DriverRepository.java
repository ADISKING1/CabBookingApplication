package task.CabBookingApplication.Repository;

import org.springframework.stereotype.Component;
import task.CabBookingApplication.Model.Driver;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriverRepository {
    private final List<Driver> drivers;

    public DriverRepository() {
        drivers = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public Driver findDriverByName(String name) {
        return drivers.stream()
                .filter(driver -> driver.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    public List<Driver> getAllDrivers() {
        return drivers;
    }
}
