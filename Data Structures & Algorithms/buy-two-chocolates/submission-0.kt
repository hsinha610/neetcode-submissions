class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {

        prices.sort()

        return if(prices[0]+prices[1]<= money){
            money - prices[0] - prices[1]
        } else {
            money
        }
    }
}
