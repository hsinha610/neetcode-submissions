class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {

        var indexOfX = -1

        var start = 0
        var end = arr.lastIndex

        while(start <= end){
            val mid = start + (end-start)/2
            
            if(arr[mid]==x){
                indexOfX = mid
                break
            } else if(arr[mid]<x){
                start = mid+1
            } else {
                end = mid -1
            }
        }

        val ans = ArrayDeque<Int>()

        if(indexOfX != -1){
            ans.addFirst(x)

            var left = indexOfX-1
            var right = indexOfX+1

            while(left>=0 && right<=arr.lastIndex){
                if(ans.size == k){
                    break
                }
                
                val toAdd = findNearElement(x,arr[left], arr[right])

                if(toAdd == arr[left]){
                    ans.addFirst(toAdd)
                    left--
                } else{
                    ans.addLast(toAdd)
                    right++
                }
            }

            while(ans.size<k && left >=0){
                ans.addFirst(arr[left--])
            }
            while(ans.size<k && right <= arr.lastIndex){
                ans.addLast(arr[right++])
            }
        } else{

            var left = end
            var right = start

            while(left>=0 && right<=arr.lastIndex){
                if(ans.size==k){
                    break
                }
                
                val toAdd = findNearElement(x,arr[left], arr[right])

                if(toAdd == arr[left]){
                    ans.addFirst(toAdd)
                    left--
                } else{
                    ans.addLast(toAdd)
                    right++
                }
            }

            while(ans.size<k && left >=0){
                ans.addFirst(arr[left--])
            }
            while(ans.size<k && right <= arr.lastIndex){
                ans.addLast(arr[right++])
            }

        }

        return ans.toList()
        
    }

    private fun findNearElement(x: Int, left: Int, right: Int): Int{
        val d1 = abs(x-left)
        val d2 = abs(x-right)

       return if(d1<d2){
        left
       } else if(d1>d2){
        right
       } else {
        left
       }
    }
}
