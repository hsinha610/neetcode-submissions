class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {

            var start = weights.max()
            var end = weights.sum()

            var ans = end

            fun calculateDays(capacity: Int) :Int{
                var totalDays = 0
                var weightLoaded = 0

                weights.forEach{ weight ->
                    weightLoaded += weight

                    if(weightLoaded > capacity){
                        totalDays++
                        weightLoaded = weight
                    } else if(weightLoaded == capacity){
                        totalDays++
                        weightLoaded = 0
                    }
                }

                if(weightLoaded != 0){
                    totalDays++
                }

                return totalDays
            }

            while(start <= end){
                val possibleCapacity = start + (end-start)/2

                val totaldays = calculateDays(possibleCapacity)

                if(totaldays <= days){
                    ans = possibleCapacity
                    end = possibleCapacity - 1
                } else {
                    start = possibleCapacity + 1
                }
            }

            return ans
    }
}
