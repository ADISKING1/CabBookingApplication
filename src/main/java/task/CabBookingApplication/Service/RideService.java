package task.CabBookingApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.CabBookingApplication.Exception.DriverNotAvailableException;
import task.CabBookingApplication.Exception.UserNotFoundException;
import task.CabBookingApplication.Model.Driver;
import task.CabBookingApplication.Model.Location;
import task.CabBookingApplication.Model.User;
import task.CabBookingApplication.Repository.DriverRepository;
import task.CabBookingApplication.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RideService {

    @Autowired
    UserRepository users;
    @Autowired
    DriverRepository drivers;

    public List<Driver> findRide(String username, Location source, Location destination) {
        User user = users.findUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers.getAllDrivers()) {
            if (driver.isAvailable() && isDriverInRange(driver.getCurrentLocation(), source)) {
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }

    private boolean isDriverInRange(Location driverLocation, Location source) {
        double distance = Math.sqrt(
                Math.pow(driverLocation.getLatitude() - source.getLatitude(), 2) +
                        Math.pow(driverLocation.getLongitude() - source.getLongitude(), 2)
        );
        return distance <= 5;
    }


    public void chooseRide(String username, String driverName) {
        User user = users.findUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        Driver chosenDriver = drivers.findDriverByName(driverName);
        if (chosenDriver == null || !chosenDriver.isAvailable()) {
            throw new DriverNotAvailableException("Driver not available");
        }

        // Perform ride booking logic
        chosenDriver.setAvailable(false);
        System.out.println(username + " has booked a ride with " + driverName);
    }

}
