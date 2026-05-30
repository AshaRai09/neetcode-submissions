class Solution {
    public int maxArea(int[] heights) {
        int  n = heights.length;
        int l=0;
        int r=n-1;
        int area;
        int maxArea=0;
        while(l<r){
            int length = Math.min(heights[l],heights[r]);
            int bredth= r-l;
            area = length*bredth;

        maxArea = Math.max(maxArea , area);
        if(heights[l]<=heights[r]){
            l++;
        }
        else{
            r--;
        }
        }
        return maxArea;
    }
}
