import java.util.Objects;

public class Patient {
    private int insuranceId;
    private String name;
    private String typeOfDiagnosis;
    private int treatmentPrice;

    public Patient(int id, String name, String typeOfDiagnosis, int treatmentPrice) {
        this.insuranceId = id;
        this.name = name;
        this.typeOfDiagnosis = typeOfDiagnosis;
        this.treatmentPrice = treatmentPrice;
    }

    public Patient(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    Patient() {
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfDiagnosis() {
        return typeOfDiagnosis;
    }

    public void setTypeOfDiagnosis(String typeOfDiagnosis) {
        this.typeOfDiagnosis = typeOfDiagnosis;
    }

    public int getTreatmentPrice() {
        return treatmentPrice;
    }

    public void setTreatmentPrice(int treatmentPrice) {
        this.treatmentPrice = treatmentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return insuranceId == patient.insuranceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(insuranceId);
    }

    @Override
    public String toString() {
        return "Patient: " + "insuranceId - " + insuranceId + ", name - " + name +
                ", diagnosis - " + typeOfDiagnosis + ", treatmentPrice - " + treatmentPrice + ".";
    }
}

