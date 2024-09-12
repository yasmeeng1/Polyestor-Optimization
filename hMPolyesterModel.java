import java.util.Scanner;

public class hMPolyesterModel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input parameters
        System.out.print("Enter H&M's current polyester percentage: ");
        double currentPolyester = scanner.nextDouble();

        System.out.print("Enter H&M's current price (does not have to be exact, just relative to the competitor): ");
        double currentPrice = scanner.nextDouble();

        System.out.print("Enter Competitior's polyester percentage: ");
        double competitorPolyester = scanner.nextDouble();

        System.out.print("Enter Competitior's price: ");
        double competitorPrice = scanner.nextDouble();

        // Calculate optimal polyester percentage
        double optimalPolyester = calculateOptimalPolyester(currentPolyester, currentPrice, competitorPolyester, competitorPrice);

        // Output results
        System.out.printf("Optimal polyester percentage for H&M: %.2f%%\n", optimalPolyester);
        System.out.printf("Estimated new price: $%.2f\n", estimateNewPrice(currentPolyester, currentPrice, competitorPolyester, competitorPrice, optimalPolyester));

        scanner.close();
    }

    // Calculates the optimal polyester percentage by adding the currentPolyester variable to the calculated increase
    // This method is based on the idea that there is a linear, direct relationship between polyester percentage and price reduction
    public static double calculateOptimalPolyester(double currentPolyester, double currentPrice, double competitorPolyester, double competitorPrice) {
        double polyesterDifference = competitorPolyester - currentPolyester;
        double priceDifference = currentPrice - competitorPrice;
        double priceReductionPerPolyester = priceDifference / polyesterDifference;

        // Aim for a price point halfway between current price and the competitior's price
        double targetPriceReduction = priceDifference / 2;
        double polyesterIncrease = targetPriceReduction / priceReductionPerPolyester;

        return currentPolyester + polyesterIncrease;
    }

    public static double estimateNewPrice(double currentPolyester, double currentPrice, double competitorPolyester, double competitorPrice, double newPolyester) {
        double polyesterDifference = competitorPolyester - currentPolyester;
        double priceDifference = currentPrice - competitorPrice;
        double priceReductionPerPolyester = priceDifference / polyesterDifference;

        double polyesterIncrease = newPolyester - currentPolyester;
        return currentPrice - (polyesterIncrease * priceReductionPerPolyester);
    }
}
