package pers.xiaoming.javaweb.springmvc.exception;

public class AgeException extends RuntimeException {
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
