function minimumPairRemoval(nums) {
    let operations = 0;
    while (!isSorted(nums)) {
        let minSum = Infinity;
        let index = -1;
        // Find the leftmost adjacent pair with the minimum sum
        for (let i = 0; i < nums.length - 1; i++) {
            const sum = nums[i] + nums[i + 1];
            if (sum < minSum) {
                minSum = sum;
                index = i;
            }
        }
        // Merge the pair at index and index + 1
        const merged = nums[index] + nums[index + 1];
        nums.splice(index, 2, merged); // Remove 2 elements and insert the sum
        operations++;
    }
    return operations;
}
;
function isSorted(arr) {
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) {
            return false;
        }
    }
    return true;
}
const input = [5, 2, 3, 1];
const inputCopy = [...input];
const results = minimumPairRemoval(inputCopy);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
