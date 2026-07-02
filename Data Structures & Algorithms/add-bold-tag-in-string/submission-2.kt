class Solution {
    fun addBoldTag(s: String, words: Array<String>): String {
        val isBold = BooleanArray(s.length)

        words.forEach{
            var startIndex = s.indexOf(it)
            while(startIndex != -1){
                for(i in startIndex..(startIndex+it.length-1)){
                    isBold[i] = true
                }
                startIndex = s.indexOf(it,startIndex+1)
            }
        }

        val ans = buildString {
            s.forEachIndexed{ ind, c->
                if(isBold[ind]){
                    if(ind-1>=0){
                        if(isBold[ind-1]){

                        } else{
                            append("<b>")
                        }
                    } else {
                        append("<b>")
                    }
                } else {
                    if(ind-1>=0){
                        if(isBold[ind-1]){
                            append("</b>")
                        }
                    }
                }

                append("$c")
            }
        }

       return if(isBold[s.lastIndex]){
            ans + "</b>"
        } else{
            ans
        }        

    }
}
