class Solution {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {

        var sum = 0
        var ans = 0

        var start = 0
        var end = 0

        repeat(k){
            sum += arr[end]
            end++
        }
        
        if(sum/k >= threshold){
            ans++
        }

        while(end < arr.size){
            sum += arr[end++]
            sum -= arr[start++]

            if(sum/k >= threshold){
            ans++
            }
        }

        return ans

    }
}
