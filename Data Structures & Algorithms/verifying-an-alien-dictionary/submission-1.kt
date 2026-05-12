class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        
        val m = mutableMapOf<Char,Int>()

        order.forEachIndexed{i,c -> m[c] = i}

       return words.sortedWith { a , b ->
                val count = min(a.length,b.length)

                var i = 0

                while(i < count){
                    if(a[i]!=b[i]){
                        break
                    } else {
                        i++
                    }
                } 

                if(i == count){
                    a.length - b.length
                } else {
                    if((m[a[i]]?:-1) < (m[b[i]]?:-1)){
                        -1
                    } else if((m[a[i]]?:-1) == (m[b[i]]?:-1)){
                        a.length - b.length
                    } else {
                        1
                    }
                }
        }.toList().zip(words.toList()).all{ it.first == it.second}
    }
}
