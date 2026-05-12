class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {

        val prefix = mutableListOf<Int>(0)

        nums.forEach {
            prefix.add(it + prefix.last())
        }

        var ans = 0

        for(i in 0..(prefix.lastIndex-1)){
            for(j in (i+1)..prefix.lastIndex){
                var sum = prefix[j] - prefix[i]

                if(sum==k){
                    ans++
                }
            }
        }

        return ans

        
    }
}
