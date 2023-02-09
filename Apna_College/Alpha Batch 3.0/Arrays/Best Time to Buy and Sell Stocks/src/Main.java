
public class Main
{
    public static int buyAndSellStocks(int sellPrice[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i =0; i < sellPrice.length; i++){
            if(buyPrice < sellPrice[i]){
                int profit = sellPrice[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);

            }else{
                buyPrice = sellPrice[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] numbers = {7, 1, 5, 3, 6, 4};
        System.out.println(buyAndSellStocks(numbers));
    }
}
