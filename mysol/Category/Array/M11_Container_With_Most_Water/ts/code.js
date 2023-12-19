function maxArea(height) {
    var maxArea = 0;
    var left = 0;
    var right = height.length - 1;
    while (left < right) {
        // Calculate the area
        var width = right - left;
        var minHeight = Math.min(height[left], height[right]);
        var area = width * minHeight;
        // Update the maximum area
        maxArea = Math.max(maxArea, area);
        // Move the pointer pointing to the shorter line inward
        if (height[left] < height[right]) {
            left++;
        }
        else {
            right--;
        }
    }
    return maxArea;
}
;
var input1 = [1, 8, 6, 2, 5, 4, 8, 3, 7];
var output1 = maxArea(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
