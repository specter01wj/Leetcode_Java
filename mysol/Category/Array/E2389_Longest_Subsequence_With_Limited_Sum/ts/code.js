function answerQueries(nums, queries) {
    // Sort the nums array
    nums.sort(function (a, b) { return a - b; });
    // Convert nums into a prefix sum array
    for (var i = 1; i < nums.length; ++i) {
        nums[i] += nums[i - 1];
    }
    // Process each query using a modified binary search
    return queries.map(function (query) {
        var left = 0, right = nums.length - 1, result = 0;
        while (left <= right) {
            var mid = Math.floor((left + right) / 2);
            if (nums[mid] <= query) {
                result = mid + 1;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    });
}
var nums = [4, 5, 2, 1], queries = [3, 10, 21];
var output = answerQueries(nums, queries);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
