package task.CabBookingApplication.Exception;

// could be used for Exceptions when using complex logic to book ride
public class RideBookingException extends RuntimeException {
    public RideBookingException(String message, Throwable cause) {
        super(message, cause);
    }
}
