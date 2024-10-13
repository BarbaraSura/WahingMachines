package pl.spooksoft.washingmachine.exceptions;

public class LoadToHeavyExeption extends RuntimeException {
    public LoadToHeavyExeption() {
    }

    public LoadToHeavyExeption(String message) {
        super(message);
    }

    public LoadToHeavyExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public LoadToHeavyExeption(Throwable cause) {
        super(cause);
    }

    public LoadToHeavyExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
