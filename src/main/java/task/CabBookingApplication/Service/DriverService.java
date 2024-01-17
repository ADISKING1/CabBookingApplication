package task.CabBookingApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.CabBookingApplication.Model.Driver;
import task.CabBookingApplication.Model.Location;
import task.CabBookingApplication.Repository.DriverRepository;

@Service
public class DriverService {
    @Autowired
    DriverRepository drivers;

    public void addDriver(String name, String gender, int age, String vehicleDetails, Location currentLocation) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setGender(gender);
        driver.setAge(age);
        driver.setVehicleDetails(vehicleDetails);
        driver.setCurrentLocation(currentLocation);
        driver.setAvailable(true);
        drivers.addDriver(driver);
    }
}
