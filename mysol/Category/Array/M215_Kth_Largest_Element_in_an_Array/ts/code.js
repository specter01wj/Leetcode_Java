function findKthLargest(nums, k) {
    return quickSort(nums, 0, nums.length - 1, k);
}
;
function quickSort(nums, left, right, k) {
    if (left <= right) {
        var p = partition(nums, left, right);
        if (p == nums.length - k) {
            return nums[p];
        }
        else if (p > nums.length - k) {
            return quickSort(nums, left, p - 1, k);
        }
        else {
            return quickSort(nums, p + 1, right, k);
        }
    }
    return -1; // This line is reached only if the input array is empty
}
function partition(nums, left, right) {
    var _a, _b;
    var pivot = nums[left];
    var i = left + 1, j = right;
    while (true) {
        while (i <= right && nums[i] < pivot) {
            i++;
        }
        while (j >= left + 1 && nums[j] > pivot) {
            j--;
        }
        if (i > j) {
            break;
        }
        _a = [nums[j], nums[i]], nums[i] = _a[0], nums[j] = _a[1]; // Swap using destructuring assignment
        i++;
        j--;
    }
    _b = [nums[j], nums[left]], nums[left] = _b[0], nums[j] = _b[1]; // Swap pivot into correct position
    return j;
}
var input1 = [3, 2, 1, 5, 6, 4];
var k = 2;
var output1 = findKthLargest(input1, k);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
