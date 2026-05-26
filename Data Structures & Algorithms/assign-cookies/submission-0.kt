class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {

        var ans = 0

        var pointerG = 0
        var pointerS = 0

        g.sort()
        s.sort()

        while(pointerG < g.size && pointerS < s.size){
            if(s[pointerS] >= g[pointerG]){
                ans++
                pointerS++
                pointerG++
            } else {
                pointerS++
            }
        }

        return ans

    }
}
