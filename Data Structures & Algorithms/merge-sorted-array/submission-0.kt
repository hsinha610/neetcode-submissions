class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i1 = m-1
        var i2 = n-1

        var i = m+n-1

        while(i1 >= 0 && i2 >= 0){
            if(nums1[i1] > nums2[i2]){
                nums1[i--]= nums1[i1--]
                
            } else if(nums1[i1] < nums2[i2]){
                nums1[i--]= nums2[i2--]
            } else {
                nums1[i--] = nums1[i1--]
            }
        }

        while(i1 >= 0){
            nums1[i--] = nums1[i1--]
        }

        while(i2 >= 0){
            nums1[i--] = nums2[i2--]
        }


    }
}
