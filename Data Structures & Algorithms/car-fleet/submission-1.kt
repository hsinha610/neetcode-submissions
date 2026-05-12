class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        
        val timeTaken = Array<Pair<Int,Double>>(position.size){ position[it] to (target-position[it]).toDouble()/speed[it]}

        val sortedByPosition = timeTaken.toList().sortedBy{ it.first }

        val stack = ArrayDeque<Double>()

        sortedByPosition.forEach{ (pos,time)->
            stack.addLast(time)
        }

        if(stack.size == 1) return 1

        var ans = 0

        var maxTillNow : Double = stack.last()

        while(stack.isNotEmpty()){


            if(stack.size >= 2){
            val a = stack.removeLast()
            val b = stack.removeLast()

            if(a<b && b > maxTillNow) {
                ans++
                stack.addLast(b)
            } else if(a==b){
                stack.addLast(b)
            } else {
                stack.addLast(b)
            }

            maxTillNow = max(maxTillNow,b)
            } else {
                stack.removeLast()
                ans++
            }
        }

        return ans
    }
}
