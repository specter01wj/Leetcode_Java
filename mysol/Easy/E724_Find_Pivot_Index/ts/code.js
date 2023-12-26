function pivotIndex(nums) {
    var totalSum = 0;
    var leftSum = 0;
    // Calculate the total sum of the array
    nums.forEach(function (num) { return totalSum += num; });
    // Iterate through the array to find the pivot index
    for (var i = 0; i < nums.length; i++) {
        if (leftSum === totalSum - leftSum - nums[i]) {
            return i; // Found the pivot index
        }
        leftSum += nums[i]; // Update the left sum for the next iteration
    }
    return -1; // No pivot index found
}
;
var input1 = [1, 7, 3, 6, 5, 6];
var output1 = pivotIndex(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
