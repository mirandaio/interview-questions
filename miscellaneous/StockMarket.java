public class StockMarket {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You need to enter stock prices.");
            System.exit(1);
        }

        int[] arr = new int[args.length];

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(args[i]);

        int[] result = stockMarket(arr);

        System.out.println("Buy: " + result[0]);
        System.out.println("Sell: " + result[1]);
    }

    /* Say you have an array for which the ith element is the price of a given
     * stock on day i. If you were only permitted to buy one share of the 
     * stock and sell one share of the stock, design an algorithm to find the 
     * best times to buy and sell.
     */
    public static int[] stockMarket(int[] arr) {
        int buy = 0;    // index of when to buy
        int sell = 0;   // index of when to sell
        int lowest = 0; // index of the lowest stock price

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] - arr[lowest] > arr[sell] - arr[buy]) {
                buy = lowest;
                sell = i;
            }

            if(arr[i] < arr[lowest])
                lowest = i;
        }

        return new int[] {buy, sell};
    }
}
