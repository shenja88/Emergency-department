import java.util.Comparator;

public class SortByPrice implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getTreatmentPrice() - o2.getTreatmentPrice();
    }
}
