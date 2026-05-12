class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        var ans = 11111

        var mem = IntArray(11111){ -2 }

        coins.sortDescending()

        fun helper(remAmount : Int) : Int{
            if(remAmount < 0 ) return 11111
            if(remAmount == 0) {
                return 0
            }
            if(mem[remAmount] != -2) return mem[remAmount]

            var localAns = 11111

            for(i in coins){
                if(i <= remAmount){
                    val res = helper(remAmount - i)
                    if (res != 11111) {
                        localAns = min(localAns, 1 + res)
                    }
                }
            }

            mem[remAmount] = localAns
            return localAns
    
        }

        val x = helper(amount)

        return x.takeIf{ it != 11111} ?: -1
    }
}