public class CoinMachine {
    public static void main(String[] args) {

        String amountReceived = args[0];
        String TheCostOfTheItem = args[1];
        int requiredChange = Integer.parseInt(amountReceived) - Integer.parseInt(TheCostOfTheItem);

        int t = requiredChange/200;
        int l= (requiredChange - (t*200)) / 100;
        int q=(requiredChange-((t*200) +( l*100)) )/ 25;
        int d = (requiredChange - ((t*200) +( l*100) + (q*25)))/ 10;
        int n = ( requiredChange - ((t*200) +( l*100) + (q*25) + (d*10))) / 5;


        System.out.println("Amount received:  " + Integer.parseInt(amountReceived));
        System.out.println("Cost of the item:  " + Integer.parseInt(TheCostOfTheItem));
        System.out.println("Required Change: " + requiredChange);
        System.out.println();
        System.out.println("change:");
        System.out.println("  toonies x " + t);
        System.out.println("  loonie x " + l);
        System.out.println("  quarter x " + q);
        System.out.println("  dime x " + d);
        System.out.println("  nickel x " + n);
    }
}
