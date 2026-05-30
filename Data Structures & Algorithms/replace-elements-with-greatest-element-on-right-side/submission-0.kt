class Solution {
    fun replaceElements(arr: IntArray): IntArray {

        var maxTillNow = arr.last()

        for(i in arr.lastIndex-1 downTo 0){
            var current = arr[i]
            arr[i] = maxTillNow
            maxTillNow = max(maxTillNow, current)
        }

        arr[arr.lastIndex] = -1

        return arr
    }
}
