package pl.spooksoft.washingmachine.exceptions;

public class TemperatureOutOfRange extends RuntimeException {

    public TemperatureOutOfRange() {
    }

    public TemperatureOutOfRange(String message) {
        super(message);
    }

    public TemperatureOutOfRange(String message, Throwable cause) {
        super(message, cause);
    }

    public TemperatureOutOfRange(Throwable cause) {
        super(cause);
    }

    public TemperatureOutOfRange(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
