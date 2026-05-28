class Solution {
    fun minOperations(logs: Array<String>): Int {

        val stack = ArrayDeque<String>()

        for(it in logs){
            if(it == "./"){

            } else if(it == "../") {
                if(stack.isNotEmpty())
                stack.removeLast()
            } else {
                stack.add(it)
            }
        }

        return stack.size
    }
}
