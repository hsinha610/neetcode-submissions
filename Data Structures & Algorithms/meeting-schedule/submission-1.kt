/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {

        val time = BooleanArray(1000001)
        for(i in intervals){
            for(j in i.start..(i.end-1)){
                if(time[j]){
                    return false
                } else {
                    time[j] = true
                }
            }
        }

        return true
    }
}
