package hospitall;

class InsufficientPermissionException extends Exception {
    private static final long serialVersionUID = 1L;

	public InsufficientPermissionException(String message) {
        super(message);
    }
}