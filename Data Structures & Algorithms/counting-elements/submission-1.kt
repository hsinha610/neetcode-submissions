class Solution {
    fun countElements(arr: IntArray): Int {

        var seen = mutableSetOf<Int>()

        arr.forEach{
            seen.add(it)
        }

        var ans = 0

        arr.forEach{
            if((it+1) in seen){
                ans++
            }
        }

        return ans
    }
}
