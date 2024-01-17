package task.CabBookingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import task.CabBookingApplication.Model.Driver;
import task.CabBookingApplication.Model.Location;
import task.CabBookingApplication.Service.DriverService;
import task.CabBookingApplication.Service.RideService;
import task.CabBookingApplication.Service.UserService;

import java.util.List;

@SpringBootApplication
public class CabBookingApplication implements CommandLineRunner {

    @Autowired
    RideService rideService;
    @Autowired
    UserService userService;
    @Autowired
    DriverService driverService;

    public static void main(String[] args) {
        SpringApplication.run(CabBookingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.addUser("Abhishek", "M", 23);
        userService.addUser("Rahul", "M", 29);
        userService.addUser("Nandini", "F", 22);

        // Onboard drivers
        driverService.addDriver("Driver1", "M", 22, "Swift, KA-01-12345", new Location(10, 1));
        driverService.addDriver("Driver2", "M", 29, "Swift, KA-01-12345", new Location(11, 10));
        driverService.addDriver("Driver3", "M", 24, "Swift, KA-01-12345", new Location(5, 3));

        // Test cases
        // Since all the driver are more than 5 units away from user
        System.out.println(rideService.findRide("Abhishek", new Location(0, 0), new Location(20, 1)));// No ride found

        // Test and book ride
        List<Driver> availableDrivers = rideService.findRide("Rahul", new Location(10, 0), new Location(15, 3));
        System.out.println(availableDrivers); // Driver1 available
        rideService.chooseRide("Rahul", availableDrivers.get(0).getName());

        // Driver1 is set to not available
        System.out.println(rideService.findRide("Nandini", new Location(10, 1), new Location(20, 4))); // No ride found
    }
}
