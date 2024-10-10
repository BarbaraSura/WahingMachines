package pl.spooksoft.washingmachine.exceptions;

public class InvalidSpinSpeedException extends RuntimeException {
    public InvalidSpinSpeedException() {
    }

    public InvalidSpinSpeedException(String message) {
        super(message);
    }

    public InvalidSpinSpeedException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSpinSpeedException(Throwable cause) {
        super(cause);
    }

    public InvalidSpinSpeedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
