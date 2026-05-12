class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {

        var five = 0
        var ten = 0
        var twenty = 0

        for(bill in bills){
            if(bill == 5){
                five++
            } else if(bill == 10){
                if(five != 0){
                    ten++
                    five--
                } else {
                    return false
                }
            } else if(bill == 20){
                if(five != 0 && ten != 0){
                    twenty ++
                    five--
                    ten--
                } else if(five > 2){
                    twenty ++
                    five -=3
                } else {
                    return false
                }
            }
        }

        return true

    }
}
