public class DuplicatedPatientException extends Exception {
    private final int idPatient;

    public DuplicatedPatientException(int idPatient) {
        this.idPatient = idPatient;
    }

    @Override
    public String getMessage() {
        return "A patient with ID ( " + idPatient + " ) already exists in the department. Repeat entry.";
    }
}
