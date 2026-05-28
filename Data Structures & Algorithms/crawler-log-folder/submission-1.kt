class Solution {
    fun minOperations(logs: Array<String>): Int {

        val stack = ArrayDeque<String>()

        logs.forEach{
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
