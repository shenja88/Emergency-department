import java.util.*;

public class ApplicationDepartment {
    private final LinkedHashSet<Patient> listPatient = new LinkedHashSet<>();

    public void startApp() {
        menuApp();
    }

    private void menuApp() {
        while (true) {
            viewMenu();
            switch (Input.inpMenu()) {
                case 1 -> sortPatient();
                case 2 -> {
                    try {
                        addPatient();
                    } catch (DuplicatedPatientException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> removePatient(Input.inpId());
                case 4 -> updatePatient(Input.inpId());
                case 5 -> {
                    return;
                }
            }
        }
    }

    private void viewMenu() {
        System.out.println("""
                Select an operation:
                1 - view patient list.
                2 - adding a patient to the list.
                3 - remove a patient from the list.
                4 - patient ID search and data editing.
                5 - exit.
                """);
    }

    private void sortPatient() {
        System.out.println("""
                Select the type of sorting:
                1 - sort by treatment price (from low to high).
                2 - sort by treatment price (from high to low).
                3 - sort patients by age of addition.""");
        switch (Input.inpSortMenu()) {
            case 1 -> sortByPrice(1);
            case 2 -> sortByPrice(2);
            case 3 -> sortByAddReverse();
        }
    }

    private void sortByAddReverse() {
        ArrayList<Patient> patients = new ArrayList<>(listPatient);
        ListIterator<Patient> itr = patients.listIterator(listPatient.size());
        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }
    }

    private void sortByPrice(int x) {
        ArrayList<Patient> patients = new ArrayList<>(listPatient);
        if (x == 1) {
            patients.sort(new SortByPrice());
        } else if (x == 2) {
            patients.sort(new SortByPrice().reversed());
        }
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    private void addPatient() throws DuplicatedPatientException {
        Patient patient = new Patient(Input.inpId(), Input.inpName(), Input.inpDiagnosis(), Input.inpPrice());
        while (true) {
            if (listPatient.contains(patient)) {
                throw new DuplicatedPatientException(patient.getInsuranceId());
            } else {
                listPatient.add(patient);
                break;
            }
        }
    }

    private void removePatient(int id) {
        if (listPatient.contains(new Patient(id))) {
            listPatient.remove(new Patient(id));
        } else {
            System.out.println("There is no patient with this ID " + id + ". Repeat entry.");
        }
    }

    private void updatePatient(int id) {
        ArrayList<Patient> patients = new ArrayList<>(listPatient);
        int x = patients.indexOf(new Patient(id));
        if (x >= 0) {
            patients.get(x).setName(Input.inpName());
            patients.get(x).setTypeOfDiagnosis(Input.inpDiagnosis());
            patients.get(x).setTreatmentPrice(Input.inpPrice());
        } else {
            System.out.println("There is no patient with this ID " + id + ". Repeat entry.");
        }
    }
}

