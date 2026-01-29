import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {
    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Arm Precision:");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density:");
        int workerDensity = sc.nextInt();

        sc.nextLine(); // clear buffer

        System.out.println("Enter Machinery State:");
        String machineryState = sc.nextLine();

        // Echo inputs (for UC2 clarity)
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);
    }
}

