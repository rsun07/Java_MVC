package pers.xiaoming.javamvc.jetty.exception;

public class NotHandledException extends RuntimeException {
    public NotHandledException() {
    }

    public NotHandledException(String message) {
        super(message);
    }
}
