class Solution {
    fun countOdds(low: Int, high: Int): Int {
        val total = high-low+1

      return  if(low%2==0 && high%2==0){
            total/2
        } else if(low%2==1 && high%2==0){
            total/2
        } else if(low%2==0 && high%2==1){
            total/2
        } else {
            total/2+1
        }
    }
}
