package chemfiles;


public class ChemfilesException extends Exception {
    private static final long serialVersionUID = 1L;

    public ChemfilesException() {}

    public ChemfilesException(String message) {
        super(message);
    }

    public ChemfilesException(Throwable cause) {
        super(cause);
    }

    public ChemfilesException(String message, Throwable cause) {
        super(message, cause);
    }
}
