package task.CabBookingApplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import task.CabBookingApplication.Exception.DriverNotAvailableException;
import task.CabBookingApplication.Exception.UserNotFoundException;
import task.CabBookingApplication.Repository.DriverRepository;
import task.CabBookingApplication.Repository.UserRepository;
import task.CabBookingApplication.Service.RideService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CabBookingApplicationTests {

    @Autowired
    RideService rideService;
    @Autowired
    UserRepository users;
    @Autowired
    DriverRepository drivers;

    @Test
    void contextLoads() {
        assertThat(rideService).isNotNull();
        assertThat(users).isNotNull();
        assertThat(drivers).isNotNull();
    }

    @Test
    void testRepositories() {
        Assertions.assertEquals(drivers.getAllDrivers().size(), 3);
        Assertions.assertEquals(users.getAllUsers().size(), 3);
    }

    @Test
    void testRideService() {
        Assertions.assertThrows(UserNotFoundException.class, () -> {
            rideService.chooseRide("Rahull", "Driver1");
        });
        Assertions.assertThrows(DriverNotAvailableException.class, () -> {
            rideService.chooseRide("Nandini", "Driver1");
        });
    }

}
