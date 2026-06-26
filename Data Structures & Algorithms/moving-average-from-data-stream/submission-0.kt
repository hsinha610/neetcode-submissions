class MovingAverage(private val size: Int) {

    val window = ArrayDeque<Int>()
    var total = 0L

    fun next(`val`: Int): Double {
        total+=`val`
        window.addLast(`val`)
        if(window.size > size){
            total -= window.first()
            window.removeFirst()
        }

        return total.toDouble()/min(size,window.size)
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * val obj = MovingAverage(size)
 * val param_1 = obj.next(`val`)
 */
