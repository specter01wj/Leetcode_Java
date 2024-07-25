function fixedPoint(arr) {
    // Initialize the left and right pointers for binary search
    let left = 0;
    let right = arr.length - 1;
    // Perform binary search
    while (left <= right) {
        let mid = Math.floor(left + (right - left) / 2);
        if (arr[mid] === mid) {
            // If arr[mid] == mid, we found a fixed point, but we need the smallest index
            // So we continue searching in the left half
            right = mid - 1;
        }
        else if (arr[mid] < mid) {
            // If arr[mid] < mid, the fixed point must be in the right half
            left = mid + 1;
        }
        else {
            // If arr[mid] > mid, the fixed point must be in the left half
            right = mid - 1;
        }
    }
    // After binary search, check if left points to a valid fixed point
    if (left < arr.length && arr[left] === left) {
        return left;
    }
    // If no fixed point is found, return -1
    return -1;
}
;
const arr1 = [-10, -5, 0, 3, 7];
const results = fixedPoint(arr1);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + arr1 + '<br>Result = ' + results;
