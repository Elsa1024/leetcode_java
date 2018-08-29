// https://leetcode.com/problems/rectangle-area-ii/description/
class Solution {
    long area(int[] rectangle) {
        return (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
    } 

    long overlapArea(int[] rectangle, int[] baseRectangle) {
        if (rectangle[1] >= baseRectangle[3] || rectangle[3] <= baseRectangle[1] 
            || rectangle[0] >= baseRectangle[2] || rectangle[2] <= baseRectangle[0])
            return 0;
        int x = rectangle[0] > baseRectangle[0] ? (baseRectangle[2] - rectangle[0]) : (rectangle[2] - baseRectangle[0]);
        int y = rectangle[1] > baseRectangle[1] ? (baseRectangle[3] - rectangle[1]) : (rectangle[3] - baseRectangle[1]);

        return x * y;
    }

    // leftbottomX, leftbottomY, righttopX, righttopY
    public int rectangleArea(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0)
            return 0; 
        int[] rectangle = rectangles[0], baseRectangle;
        long totalArea = 0, initialArea;
        totalArea += area(rectangle);
        System.out.println("area of rect 0: " + totalArea);
        for (int i = 1; i < rectangles.length; i++) {
            rectangle = rectangles[i];
            initialArea = area(rectangle);
            for (int j = 0; j < i; j++)  {
                baseRectangle = rectangles[j];
                initialArea -= overlapArea(rectangle, baseRectangle);
                if (initialArea <= 0)
                    break;
            }
            System.out.println("area of rect " + i + ": " + initialArea);
            totalArea += initialArea > 0 ? initialArea : 0;
        }

        return (int)(totalArea % (int)(Math.pow(10, 9) + 7));
    }
}
