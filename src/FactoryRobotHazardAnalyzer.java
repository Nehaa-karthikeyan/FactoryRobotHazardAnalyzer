import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = sc.nextInt();

        sc.nextLine(); // clear buffer

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = sc.nextLine();

        try {
            double risk = calculateHazardRisk(
                    armPrecision, workerDensity, machineryState
            );
            System.out.println("Robot Hazard Risk Score: " + risk);
        }
        catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }
    }

    // UC7: Hazard calculation with clean risk mapping
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState)
            throws RobotSafetyException {

        double machineRiskFactor;

        // Validate arm precision
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0"
            );
        }

        // Validate worker density
        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20"
            );
        }

        // UC7: Clean machinery state → risk factor mapping
        switch (machineryState) {
            case "Worn":
                machineRiskFactor = 1.3;
                break;

            case "Faulty":
                machineRiskFactor = 2.0;
                break;

            case "Critical":
                machineRiskFactor = 3.0;
                break;

            default:
                throw new RobotSafetyException(
                        "Error: Unsupported machinery state"
                );
        }

        // Hazard risk calculation
        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}
