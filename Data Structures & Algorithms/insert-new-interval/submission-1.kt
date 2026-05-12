class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        val elements = mutableListOf<Int>()

        intervals.forEach{ (a,b)->
            elements.add(a)
            elements.add(b)
        }

        val (sn,en) = newInterval

        var isn = -2
        var snMatched = false
        var ien = -2
        var enMatched = false

        var start = 0
        var end = elements.size -1

        while(start <= end){
            val mid = start + (end-start)/2

            if(elements[mid] == sn){
                snMatched = true
                isn = mid
                break
            } else if(elements[mid] < sn){
                start = mid+1
            } else{
                end = mid-1
            }
        }

        if(isn == -2){
            isn = start
        }

        start = 0
        end = elements.size -1

        while(start <= end){
            val mid = start + (end-start)/2

            if(elements[mid] == en){
                enMatched = true
                ien = mid
                break
            } else if(elements[mid] < en){
                start = mid+1
            } else{
                end = mid-1
            }
        }

        if(ien == -2){
            ien = start
        }


        println(isn)
        println(ien)


        if(isn == ien && isn %2 == 0){
            if(isn in elements.indices)
            {elements.add(isn,sn)} else{
                elements.add(sn)
            }
            if((ien+1) in elements.indices){
            if(elements[ien+1] != en)
            {elements.add(ien +1, en) }else{
                elements.removeAt(ien+1)
            }
            } else{
                elements.add(en)
            }
        } else {
            if(isn % 2 == 1 && ien % 2 == 1 ){
                return elements.mapIndexed{ idx,i ->
                    if(idx < isn || idx >= ien){ i }else { null} 
                }.filterNotNull().chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray()
            } else if(isn % 2 == 1 && ien % 2 == 0 ){
                if(enMatched){
                   return elements.mapIndexed{ idx,i ->
                    if(idx < isn || idx > ien){ i }else { null} 
                }.filterNotNull().chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray() 
                } else{
                   return elements.apply{add(ien,en)}.mapIndexed{ idx,i ->
                    if(idx < isn || idx >= ien){ i }else { null} 
                }.filterNotNull().chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray() 
                }
            } else if(isn % 2 == 0 && ien % 2 == 0 ) {
                if(snMatched && enMatched){
                   return elements.mapIndexed{ idx,i ->
                    if(idx <= isn || idx > ien){ i }else { null} 
                }.filterNotNull().chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray()  
                }
                if(snMatched && !enMatched){
                   return elements.apply{add(ien,en)}.mapIndexed{ idx,i ->
                    if(idx <= isn || idx >= ien){ i }else { null} 
                }.filterNotNull().chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray()  
                }
                if(!snMatched && enMatched){
                   return elements.apply{add(isn,sn)}.mapIndexed{ idx,i ->
                    if(idx <= isn || idx > ien + 1){ i }else { null} 
                }.filterNotNull().chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray()  
                }
                if(!snMatched && !enMatched){
                   return elements.apply{add(isn,sn)
                   add(ien+1, en)}.mapIndexed{ idx,i ->
                    if(idx <= isn || idx >= ien + 1){ i }else { null} 
                }.filterNotNull().chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray()  
                }
            } else if(isn % 2 == 0 && ien % 2 == 1 ){
                if(snMatched){
                   return elements
                   .mapIndexed{ idx,i ->
                    if(idx <= isn || idx >= ien ){ i }else { null} 
                }.filterNotNull().chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray()  
                }
                if(!snMatched) {
                    return elements.apply{add(isn,sn)}
                   .mapIndexed{ idx,i ->
                    if(idx <= isn || idx >= ien +1 ){ i }else { null} 
                }.filterNotNull().chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray()  
                
                }
            }
        }

        return elements.chunked(2).map{ intArrayOf(it.first(),it.last())}.toTypedArray()
    }
}
