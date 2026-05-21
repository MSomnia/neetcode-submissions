class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // from left to right
        // output[i] contains the multiple results of all left elements
        output[0] = 1;
        for (int i = 1; i < n; i++)
        {
            output[i] = output[i-1]*nums[i-1];
        }

        //from right to left
        // multiply all elements on the right
        int right = 1;
        for (int i = n-1; i>=0; i--)
        {
            output[i]*=right;
            right*=nums[i];
        }
        return output;
    }
}  
