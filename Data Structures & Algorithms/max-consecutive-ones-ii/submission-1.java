class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int n = nums.length;

        int start = 0;
        int end = 0;
        int pos = -1;

        int ans = 0;

        while(end < n){
            if(nums[end]==1){
                end++;
            } else {
                ans = Math.max(ans, end-start);
                start = pos+1;
                pos = end;
                end++;
            }
        }

        ans = Math.max(ans,end-start);

        if(ans == 0 && n != 0){
            ans = n;
        }

        return ans;
    }
}
