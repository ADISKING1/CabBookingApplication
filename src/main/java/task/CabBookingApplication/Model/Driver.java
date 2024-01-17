package task.CabBookingApplication.Model;

import org.springframework.stereotype.Component;

@Component
public class Driver {
    private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private Location currentLocation;
    private boolean isAvailable;

    public Driver(String name, String gender, int age, String vehicleDetails, Location currentLocation, boolean isAvailable) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.currentLocation = currentLocation;
        this.isAvailable = isAvailable;
    }

    public Driver() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return name + " " + (isAvailable ? "[Available]" : "[Unavailable]");
    }
}
