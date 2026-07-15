class Solution {
    fun evalRPN(tokens: Array<String>): Int {

        val stack = ArrayDeque<String>()

        tokens.forEach{
            when(it){
                "+" ->{ 
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    stack.add((a.toInt() + b.toInt()).toString())
                }
                "-" ->{
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    stack.add((- a.toInt() + b.toInt()).toString())}
                "*" ->{
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    stack.add((a.toInt() * b.toInt()).toString())}
                "/" ->{
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    stack.add((b.toInt() / a.toInt()).toString())}
                else ->{
                    stack.addLast(it)
                }
            }
        }

        return stack.last().toInt()
    }
}
