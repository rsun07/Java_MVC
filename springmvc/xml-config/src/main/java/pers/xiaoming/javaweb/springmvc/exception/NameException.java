package pers.xiaoming.javaweb.springmvc.exception;

public class NameException extends RuntimeException {
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
