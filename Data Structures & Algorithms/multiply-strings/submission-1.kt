class Solution {
    fun multiply(num1: String, num2: String): String {

        if(num1 == "0" || num2 == "0") return "0"

        var ans = ""

        val n1 = num1.length
        val n2 = num2.length
        var carry = 0

        var i1 = n1 - 1
        var prods = mutableListOf<String>()

        var maxLength = 0
        while(i1>=0){
            var localAns = ""
            var i2 = n2 - 1
            carry = 0

            repeat(n1 - i1 -1){
                localAns += 0
            }

            while(i2 >= 0){
                val a = num2[i2] - '0'
                val b = num1[i1] - '0'

                val prod = a*b + carry

                carry = prod / 10
                val currAns = prod % 10

                localAns = "$currAns$localAns"

                i2--
            }
            prods.add("$carry$localAns")

            maxLength = max(maxLength, "$carry$localAns".length)
            i1--
        }

       val finalAns =  prods.reduce{ acc, ele -> sumStrings(acc,ele) }

        println(finalAns)
        return finalAns.dropWhile{ it == '0'}
    }

    fun sumStrings(s1: String, s2: String): String{

        val l1 = s1.length
        val l2 = s2.length

        val maxL = max(l1,l2)

        var p = if(l1 == maxL){
            s1
        } else {
            "0".repeat(maxL-l1) + s1
        }

        var q = if(l2 == maxL){
            s2
        } else {
            "0".repeat(maxL-l2) + s2
        }

        var carry = 0
        var ans = ""

        p.zip(q).reversed().forEach{ (a,b) -> 
            val x = a - '0'
            val y = b - '0'

            val s = x + y + carry

            carry = s / 10

            ans = "${s%10}$ans"
        }

        return if(carry == 0 ) ans else "$carry$ans"
    }
}
