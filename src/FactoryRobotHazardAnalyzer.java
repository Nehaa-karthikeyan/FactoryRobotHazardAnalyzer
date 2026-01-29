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

        double machineRiskFactor;

        // UC4: Validation using if-else
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
        }
        else if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
        }
        else if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
            double hazardRisk =
                    ((1.0 - armPrecision) * 15.0)
                            + (workerDensity * machineRiskFactor);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        }
        else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
            double hazardRisk =
                    ((1.0 - armPrecision) * 15.0)
                            + (workerDensity * machineRiskFactor);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        }
        else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
            double hazardRisk =
                    ((1.0 - armPrecision) * 15.0)
                            + (workerDensity * machineRiskFactor);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        }
        else {
            System.out.println("Error: Unsupported machinery state");
        }
    }
}
