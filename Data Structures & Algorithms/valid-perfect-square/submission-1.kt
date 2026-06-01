class Solution {
    fun isPerfectSquare(num: Int): Boolean {

        var start = 1L
        var end = num.toLong()


        while(start <= end){
            val mid = start + (end-start)/2

            if(num.toLong() == mid*mid){
                return true
            } else if(num.toLong() < mid*mid){
                end = mid-1
            } else {
                start = mid+1
            }
        }

        return false
    }
}
