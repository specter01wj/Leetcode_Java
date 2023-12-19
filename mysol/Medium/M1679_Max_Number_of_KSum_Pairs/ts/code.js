function maxOperations(nums, k) {
    var numCounts = new Map();
    var operations = 0;
    for (var _i = 0, nums_1 = nums; _i < nums_1.length; _i++) {
        var num = nums_1[_i];
        var complement = k - num;
        // Check if the complement is present and has a non-zero count
        if (numCounts.get(complement) > 0) {
            // Perform an operation and decrease the count of the complement
            operations++;
            numCounts.set(complement, numCounts.get(complement) - 1);
        }
        else {
            // Otherwise, increase the count of the current number
            numCounts.set(num, (numCounts.get(num) || 0) + 1);
        }
    }
    return operations;
}
;
var input1 = [1, 2, 3, 4], k = 5;
var output1 = maxOperations(input1, k);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
