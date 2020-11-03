package exception;

public class ResourceAlreadyExistsException extends Exception {
    public ResourceAlreadyExistsException(String s) {
        super(s);
    }

    public ResourceAlreadyExistsException() {
        super();
    }

    public ResourceAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
