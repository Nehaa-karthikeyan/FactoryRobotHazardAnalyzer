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

        double risk = calculateHazardRisk(
                armPrecision, workerDensity, machineryState
        );

        if (risk != -1) {
            System.out.println("Robot Hazard Risk Score: " + risk);
        }
    }

    // UC5 method here
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState) {

        double machineRiskFactor;

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
            return -1;
        }
        else if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
            return -1;
        }
        else if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        }
        else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        }
        else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        }
        else {
            System.out.println("Error: Unsupported machinery state");
            return -1;
        }

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }

}
