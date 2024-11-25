function minimumRightShifts(nums) {
    const n = nums.length;
    // Check if the array is already sorted
    let alreadySorted = true;
    for (let i = 1; i < n; i++) {
        if (nums[i] < nums[i - 1]) {
            alreadySorted = false;
            break;
        }
    }
    if (alreadySorted)
        return 0;
    // Find the rotation point where the sequence breaks
    let rotationPoint = -1;
    for (let i = 1; i < n; i++) {
        if (nums[i] < nums[i - 1]) {
            if (rotationPoint !== -1) {
                // More than one rotation point means it's not sortable
                return -1;
            }
            rotationPoint = i;
        }
    }
    // Check if the array is sorted after applying the rotation
    for (let i = rotationPoint; i < n - 1; i++) {
        if (nums[i] > nums[i + 1]) {
            return -1;
        }
    }
    if (nums[n - 1] > nums[0]) {
        return -1;
    }
    // Return the number of shifts needed
    return n - rotationPoint;
}
;
const input = [3, 4, 5, 1, 2];
const results = minimumRightShifts(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
