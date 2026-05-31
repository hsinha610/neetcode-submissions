class Solution {
    fun scoreOfString(s: String): Int {
        return s.toList().zipWithNext().map{ abs(it.first - it.second)}.sum()
    }
}
