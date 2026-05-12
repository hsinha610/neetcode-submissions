class Solution {
    fun plusOne(digits: IntArray): IntArray {

        var carry = 0

        for(i in digits.lastIndex downTo 0){
            val di = digits[i]
            
            if(i == digits.lastIndex){
                if(di == 9 ){
                    digits[i] = 0
                    carry = 1
                } else {
                    digits[i]++
                    carry = 0
                }
            } else {
                val newDi = di + carry

                if(newDi > 9){
                    digits[i] = 0
                    carry = 1
                } else {
                    digits[i]= newDi
                    carry = 0
                }
            }
        }

       return if(carry == 0){
            digits
        } else {
            IntArray(digits.size+1){ if(it==0){ carry} else { digits[it-1]}}
        }

    }
}
