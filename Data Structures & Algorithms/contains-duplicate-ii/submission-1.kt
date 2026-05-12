class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val seen = mutableSetOf<Int>()

        for(i in 0..min(k,nums.size-1)){
            if(nums[i] in seen){
                return true
            } else {
                seen.add(nums[i])
            }
        }

        var j = k+1
        var i = 0
        
        seen.remove(nums[i])

        i++

        while(j < nums.size){
            if(nums[j] in seen){
                return true
            } else{
                seen.add(nums[j])
                seen.remove(nums[i])
                i++
                j++
            }
        }

        return false
    }
}
