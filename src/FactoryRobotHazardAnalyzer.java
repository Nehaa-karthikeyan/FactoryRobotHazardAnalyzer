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

        // UC3: Hazard Risk Calculation (NO validation)
        double machineRiskFactor = 3.0; // assume Critical

        double hazardRisk =
                ((1.0 - armPrecision) * 15.0)
                        + (workerDensity * machineRiskFactor);

        System.out.println("Robot Hazard Risk Score: " + hazardRisk);
    }
}
