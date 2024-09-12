import java.util.Scanner;

public class hMPolyesterModel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input parameters
        System.out.print("Enter H&M's current polyester percentage: ");
        double currentPolyester = scanner.nextDouble();

        System.out.print("Enter H&M's current price: ");
        double currentPrice = scanner.nextDouble();

        System.out.print("Enter Shein's polyester percentage: ");
        double sheinPolyester = scanner.nextDouble();

        System.out.print("Enter Shein's price: ");
        double sheinPrice = scanner.nextDouble();

        // Calculate optimal polyester percentage
        double optimalPolyester = calculateOptimalPolyester(currentPolyester, currentPrice, sheinPolyester, sheinPrice);

        // Output results
        System.out.printf("Optimal polyester percentage for H&M: %.2f%%\n", optimalPolyester);
        System.out.printf("Estimated new price: $%.2f\n", estimateNewPrice(currentPolyester, currentPrice, sheinPolyester, sheinPrice, optimalPolyester));

        scanner.close();
    }

    public static double calculateOptimalPolyester(double currentPolyester, double currentPrice, double sheinPolyester, double sheinPrice) {
        double polyesterDifference = sheinPolyester - currentPolyester;
        double priceDifference = currentPrice - sheinPrice;
        double priceReductionPerPolyester = priceDifference / polyesterDifference;

        // Aim for a price point halfway between current price and Shein's price
        double targetPriceReduction = priceDifference / 2;
        double polyesterIncrease = targetPriceReduction / priceReductionPerPolyester;

        return currentPolyester + polyesterIncrease;
    }

    public static double estimateNewPrice(double currentPolyester, double currentPrice, double sheinPolyester, double sheinPrice, double newPolyester) {
        double polyesterDifference = sheinPolyester - currentPolyester;
        double priceDifference = currentPrice - sheinPrice;
        double priceReductionPerPolyester = priceDifference / polyesterDifference;

        double polyesterIncrease = newPolyester - currentPolyester;
        return currentPrice - (polyesterIncrease * priceReductionPerPolyester);
    }
}