import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inpId() {
        System.out.println("Enter insurance ID of patient: ");
        if (SCANNER.hasNextInt()) {
            int x = SCANNER.nextInt();
            if (x > 0) {
                return x;
            }
        }
        SCANNER.next();
        System.out.println("Enter the correct ID");
        return inpId();
    }

    public static String inpName() {
        SCANNER.nextLine();
        System.out.println("Enter name of patient: ");
        return SCANNER.nextLine();

    }

    public static String inpDiagnosis() {
        System.out.println("Enter type of diagnosis a patient: ");
        return SCANNER.nextLine();
    }

    public static int inpPrice() {
        System.out.println("Enter price of treatment patient: ");
        if (SCANNER.hasNextInt()) {
            int x = SCANNER.nextInt();
            if (x > 0) {
                return x;
            }
        }
        SCANNER.nextLine();
        System.out.println("Enter the correct amount.");
        return inpPrice();
    }


    public static int inpMenu() {
        if (SCANNER.hasNextInt()) {
            int x = SCANNER.nextInt();
            if (x > 0 && x < 6) {
                return x;
            }
        }
        SCANNER.nextLine();
        System.out.println("Repeat entry (1 - 5).");
        return inpMenu();
    }

    public static int inpSortMenu() {
        if (SCANNER.hasNextInt()) {
            int x = SCANNER.nextInt();
            if (x > 0 && x < 4) {
                return x;
            }
        }
        SCANNER.nextLine();
        System.out.println("Repeat entry (1 - 3).");
        return inpSortMenu();
    }
}
