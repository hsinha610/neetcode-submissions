class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {

            var t1 = 0
            var t2 = numbers.size-1

            while(t1<t2){
                if(numbers[t1] + numbers[t2] == target){
                    return intArrayOf(t1+1,t2+1)
                }

                if(numbers[t1] + numbers[t2] < target){
                    t1++
                } else {
                    t2--
                }
            }

            return intArrayOf()
    }
}
