import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class ComplexInvoiceApp {

    public static void main(String[] args) {

        // Declare and initialize a scanner to take user input
        Scanner sc = new Scanner(System.in);

        // Declare and initialize a random number generator for the tax code
        Random rand = new Random();

        // Generate a tax code from 0-3
        int taxCode = rand.nextInt(4);
        outputLine("My current tax code is: " + taxCode);

        // Declare a variable to hold the tax rate
        double taxRate = 0.0;

        // This is the condition to assign a tax rate depending on the random
        // number generator code for 0-3
        if (taxCode == 1) {
            taxRate = 0.06;
        }
        else if (taxCode == 2) {
            taxRate = 0.053;
        }
        else if (taxCode == 3) {
            taxRate = 0.0575;
        }
        else {
            taxRate = 0.05;
        }

        // Delcare and initialize computation variables
        String result = "";
        double subTotal = 0.0;
        double taxableTotal = 0.0;

        outputLine("================================================");
        outputLine("Welcome to the Behind-The-Door Break Room Cafe!");

        String userInput="";

        while(!userInput.equalsIgnoreCase("quit")) {
            output("Enter a food item you want: ");
            String foodName = sc.next();

            output("Price: ");
            double foodPrice = sc.nextDouble();

            output("Taxable? True or False: ");
            boolean taxable = sc.nextBoolean();

            output("Quantity: ");
            int foodQuantity = sc.nextInt();

            // Use a string formatter to get 2 decimal places of each food price
            String formatPrice = String.format("%.02f", foodPrice);

            // Build the string to hold all the entries
            result += foodName + "\t\t" + foodQuantity + "\t\t\t$" + formatPrice + "\t\t" + taxable + "\n";

            // Add the item cost's in subtotal
            subTotal += (foodPrice * foodQuantity);

            // Check if the taxable field is true to add to the taxableTotal
            if (taxable == true) {
                taxableTotal += (foodPrice * foodQuantity);
            }

            output("Do you want to add another item? (Type 'quit' to exit): ");
            userInput = sc.next();
        }

        // Calculate the sales tax for ONLY taxable items
        double salesTax = taxableTotal*taxRate;
        // Calculate the total amount (sales tax + sub total)
        double totalAmount = salesTax + subTotal;

        // Series of string formats to ensure everything stays within 2 decimal places
        String formatSubTotal = String.format("%.02f", subTotal);
        String formatSalesTax = String.format("%.02f", salesTax);
        String formatTotalAmount = String.format("%.02f", totalAmount);

        // Format the tax rate to a readable percentage
        NumberFormat percent = NumberFormat.getPercentInstance();
        String formatTaxRate = percent.format(taxRate);

        outputLine("================================================");
        outputLine("Item Name" + "\t\t" + "Quantity" + "\t" + "Price" + "\t\t" + "Taxable");
        outputLine(result);
        outputLine("Sub-Total = $" + formatSubTotal);
        outputLine("Tax Rate = " + formatTaxRate + " (Tax code = " + taxCode + ")");
        outputLine("Sales Tax = $" + formatSalesTax );
        outputLine("________________________________________________");
        outputLine("Total = $" + formatTotalAmount);
    }

    public static void outputLine(String message) {
        System.out.println(message);
    }

    public static void output(String message) {
        System.out.print(message);
    }



}