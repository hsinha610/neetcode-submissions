class Solution {
    fun appendCharacters(s: String, t: String): Int {

        var ps = 0
        var pt = 0

        while(ps < s.length){
            if(pt < t.length){
                if(s[ps]==t[pt]){
                    ps++
                    pt++
                } else{
                    ps++
                }
            } else {
                ps++
            }
        }

        return t.length - pt
    }
}
