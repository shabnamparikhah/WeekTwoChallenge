import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class WeekTwoChallengeClass {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String name = "";
        double price = 0;
        String priceTotal = "";
        int quantity = 5;
        String quantityTotal = "";
        int taxCode = 2;
        boolean taxable = true;
        String taxableTotal = "";
        String code = "";//you can change State "MD","VA" OR "DC" now is empty
        double description;
        double salesTax;
        double result = 0;
        double subTotal = 0;
        double subNew = 0;
        String fullname = "";
        int count=0;

        Message("startMessage");

        Random rand = new Random();
        taxCode = rand.nextInt(4);
        double taxRate = 0.0;
//        switch (code) {
//                case "MD":
//                    description = 6.00;
//                    break;
//                case "VA":
//                    description = 5.30;
//                    break;
//                case "DC":
//                    description = 5.75;
//                    break;
//                default:
//                    description = 5.0;
//                    break;
//            }
        try {
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

            while (!name.equals("quit")) {
                Message("selectFood");
                name = myScan.next();
                if (name.equals("quit")) {
                    break;
                }
                Message("enterPrice");
                price = myScan.nextDouble();
                Message("enterTax");
                taxable = myScan.nextBoolean();
                Message("enterQuantity");
                quantity = myScan.nextInt();
                Message("getAnotherItem");
                if (taxable == true) {
                    salesTax = (price * quantity);
                    result = (result + salesTax);
                }
                if ( name.equalsIgnoreCase("COCACOLA") )
                {
                    count ++;
                    if(count>= 7)
                    {
                        quantity = 7;
                    }
                }
                subTotal = (price * quantity);
                subNew = subNew + subTotal;
                fullname = fullname + name + "\t\t" + quantity + "\t\t" + price + "$" + "\t\t" + taxable + "\t" + "\n";

        }

            Message("output");

            System.out.println(fullname + "\t\t");
            System.out.println("Sub-Total : " + "$" + String.format("%.02f", subNew));
            System.out.println("Tax Rate : " + String.format("%.02f", taxRate)+" " + "(Tax code =" + taxCode +")");
            System.out.println("Sales Tax : " + "$" + String.format("%.02f", result * (taxRate / 100)));
            System.out.println("================================================");
            double MainTotal = (subNew + (result * (taxRate / 100)));
            System.out.println("Total :" + "$" +  String.format("%.02f",MainTotal));

        } catch (Exception ex) {
            System.out.println("The Input Value Is Not Valid!");
        }
    }

    private static String Message(String output)
    {
        if (output.equals("startMessage"))
        {
             System.out.println("Welcome to the Behind-The-Door Break Room Cafe!");
        }
        else if (output.equals("changeState"))
        {
            System.out.println("You can change your State (Press MD , VA OR DC) else your tax is 5.0%");
        }
        else if (output.equals("selectFood"))
        {
            System.out.println("Enter a food item you want :");
        }
        else if (output.equals("enterPrice"))
        {
            System.out.println("Price :");
        }
        else if (output.equals("enterTax"))
        {
            System.out.println("Taxable : True or False:");
        }
        else if (output.equals("enterQuantity"))
        {
            System.out.println("Quantity :");
        }
        else if (output.equals("getAnotherItem"))
        {
            System.out.println("Do you want to add another item? (Type 'quit' to exit)");
        }
        else if (output.equals("output"))
        {
            System.out.println("================================================");
            System.out.println("Item Name \t Quantity \tPrice \t  Taxable");
        }
        return  output;
    }
}
