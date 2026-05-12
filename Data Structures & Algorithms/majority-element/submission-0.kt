class Solution {
    fun majorityElement(nums: IntArray): Int {

     return   nums.toList().groupBy{ it}.mapValues{it.value.size}.maxBy{ it.value}.key
    }
}
