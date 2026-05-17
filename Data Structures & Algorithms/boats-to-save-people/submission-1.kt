class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {

        var ans = 0

        var left = 0
        var right = people.lastIndex

        people.sort()

        while(left <= right){
            if(people[left] + people[right] <= limit){
                ans++
                left++
                right--
            } else {
                ans++
                right--
            }
        }

        return ans

    }
}
