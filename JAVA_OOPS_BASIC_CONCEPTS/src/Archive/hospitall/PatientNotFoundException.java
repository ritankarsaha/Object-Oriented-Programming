package hospitall;

class PatientNotFoundException extends Exception {
    private static final long serialVersionUID = 8877136011122629087L;

	public PatientNotFoundException(String message) {
        super(message);
    }
}