class Solution {
    public int longestConsecutive(int[] nums) {
         if(nums.length==0){ 
       return 0;}
    Arrays.sort(nums);
    int maxLen=1;
    int prev=nums[0];
    int len=1;
    for(int i=0;i<nums.length;i++){
        if(prev == nums[i]){
            continue;
        }
        if(nums[i]==(prev+1)){
          len++; 
        } else{
            len=1;
        }
        prev = nums[i]; 
        maxLen = Math.max(maxLen , len);
    }
    return maxLen;
    }
}
