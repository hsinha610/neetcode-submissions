class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {

        val f = mutableMapOf<Int,Int>()

        people.forEach{
            f[it] = f.getOrDefault(it,0) + 1
        }

        var ans = 0

        people.forEach{
            if(f.getOrDefault(it,0) != 0){
                f[it] = f.getOrDefault(it,0) - 1
                for(i in limit-it downTo 1){
                    if(f.getOrDefault(i,0) != 0){
                        f[i] = f.getOrDefault(i,0) - 1
                        break
                    }
                }
                ans++
            }
        }

        return ans


    }
}
