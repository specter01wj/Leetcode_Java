function findPeakElement(nums) {
    var left = 0, right = nums.length - 1;
    while (left < right) {
        var mid = Math.floor((left + right) / 2);
        if (nums[mid] > nums[mid + 1]) {
            // Peak is in the left half or at mid
            right = mid;
        }
        else {
            // Peak is in the right half
            left = mid + 1;
        }
    }
    // When left equals right, we have found the peak element
    return left;
}
;
var input1 = [1, 2, 1, 3, 5, 6, 4];
var output1 = findPeakElement(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
