class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] nums, int target,
                           List<Integer> curr, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == nums.length || target < 0)
            return;
        if (nums[index] <= target) {
            curr.add(nums[index]);
            backtrack(index, nums, target - nums[index], curr, ans);
            curr.remove(curr.size() - 1);
        }
        backtrack(index + 1, nums, target, curr, ans); 
    }
}
