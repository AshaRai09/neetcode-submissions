class Solution {
    public int largestRectangleArea(int[] heights) {
       int n= heights.length;
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    for(int i=0 ;i<=n ;i++){   //i gives the Next Smaller Element (NSE).
      int h= (i==n)? 0 : heights[i];
      while(!stack.isEmpty() && h < heights[stack.peek()]){   // stack.peek() after popping gives the Previous Smaller Element (PSE).
        int height = heights[stack.pop()];
        int width = stack.isEmpty()? i : i-stack.peek()-1;
        int area = height*width;
        maxArea = Math.max(maxArea , area);
      }
       stack.push(i);
    }
    return maxArea; 
    }
}
