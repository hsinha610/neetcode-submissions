class Solution {
    fun isHappy(n: Int): Boolean {

        val seen = mutableSetOf<Int>()

        seen.add(n)

        var x = n

        while(true){
            
            val new = x.toString().toList().map{ it.digitToInt()}.map{it*it}.sum()
            
            if(new==1) return true

            if(seen.contains(new)) return false

            seen.add(new)

            x = new

        }

        return false

    }
}
