class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {

        val stack = mutableListOf<Pair<Int,Int>>()

        val ans = IntArray(temperatures.size){ 0 }

        for(i in temperatures.lastIndex downTo 0){

            val temp = temperatures[i]

            if(stack.isEmpty()){
                ans[i] = 0
                stack.add(temp to i)
            } else {
                
                while(stack.isNotEmpty() && stack.last().first <= temp){
                    stack.removeLast()
                }

                if(stack.isEmpty()){
                    ans[i] = 0
                    stack.add(temp to i)
                } else {
                    ans[i] = stack.last().second - i
                    stack.add(temp to i)
                }
            }
        }

        return ans

    }
}
