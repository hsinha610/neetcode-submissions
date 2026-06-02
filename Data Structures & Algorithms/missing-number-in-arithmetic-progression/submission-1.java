class Solution {
    public int missingNumber(int[] arr) {
        
        int r = (arr[arr.length-1] - arr[0])/(arr.length);

        

        int i = arr.length-1;

        while(i>0){
            if(arr[i]-r != arr[i-1]){
                return arr[i]-r;
            } else{
                i--;
            }
        }

        return arr[0];
    }
}
