class Solution {
    fun totalFruit(fruits: IntArray): Int {
        val seen = mutableSetOf<Int>()

        var start = 0
        var end = 0

        var lastIndexA = 0
        var lastIndexB = 0

        var A = -1
        var B = -1

        var ans = 0

        while(end < fruits.size){
            if(fruits[end] !in seen && seen.size == 2){
                println("end-start ${end-start}")
                ans = Math.max(ans, end-start)

                val indexToRemoveUpto = Math.min(lastIndexA,lastIndexB)
                start = indexToRemoveUpto + 1
                println("start-new $start")

                seen.remove(fruits[indexToRemoveUpto])
                seen.add(fruits[end])
                if(indexToRemoveUpto == lastIndexA){
                    lastIndexA = end
                    A = fruits[lastIndexA]
                } else{
                    lastIndexB = end
                    B = fruits[lastIndexB]
                }
                end++
            } else if(fruits[end] !in seen && seen.size < 2){
                if(A == -1){
                    A = fruits[end]
                    lastIndexA = end
                } else if(B==-1){
                    B = fruits[end]
                    lastIndexB = end
                }
                seen.add(fruits[end])
                end++
            } else if(fruits[end] in seen){
                if(fruits[end]==A){
                    lastIndexA = end
                } else{
                    lastIndexB = end
                }
                println("lastIndex of A $A = $lastIndexA")
                println("lastIndex of B $B = $lastIndexB")

                end++
            }
        }

        ans = Math.max(ans,end-start)

        return ans
    }
}
