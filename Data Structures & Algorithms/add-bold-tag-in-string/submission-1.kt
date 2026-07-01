class Solution {
    fun addBoldTag(s: String, words: Array<String>): String {

        val indexToInsert = mutableListOf<Pair<Int,Int>>()

        words.forEach { word ->
            if(word in s){

                var startIndex = s.indexOf(word)

                while(startIndex !=-1){
                val endIndex = startIndex + word.length
                    println("$word : start-$startIndex end-$endIndex")

                indexToInsert.add(startIndex-1 to endIndex)

                startIndex = s.indexOf(word,startIndex+1)
                }
                
            }
        }

        indexToInsert.sortWith(compareBy({it.first}))

        val stack = ArrayDeque<Pair<Int,Int>>()

        for(i in indexToInsert.lastIndex downTo 0){
            stack.addLast(indexToInsert[i])
        }

        val finalIndices = mutableListOf<Pair<Int,Int>>()

        while(stack.isNotEmpty()){
            if(stack.size == 1){
                finalIndices.add(stack.removeLast())
            } else{
                val (a,b) = stack.removeLast()
                val (x,y) = stack.removeLast()

                if(b<=x){
                    finalIndices.add(a to b)
                    stack.addLast(x to y)
                } else{
                    stack.addLast(a to Math.max(b,y))
                }
            }
        }

        val charArray = Array<String>(s.length + finalIndices.size*2){""}
        var counter = 0

        finalIndices.forEach{ (a,b)->
        println("a->$a, b->$b")
        if(a==-1){
            charArray[a+1] = "<b>"
            counter++
            charArray[b+counter] = "</b>"
            counter++
        } else{
            charArray[a+counter+1] = "<b>"
            counter++
            charArray[b+counter] = "</b>"
            counter++
        }
            
        }

        var indi = 0
        var indj = 0

        while(indj < charArray.size){
            if(charArray[indj] == "<b>" || charArray[indj] == "</b>"){
                indj++
            } else{
                charArray[indj++] = s[indi++].toString()
            }
        }

        return charArray.joinToString("")

    }
}
