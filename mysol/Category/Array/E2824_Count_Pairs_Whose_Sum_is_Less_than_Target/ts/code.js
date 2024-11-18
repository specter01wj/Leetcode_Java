function countPairs(nums, target) {
    let count = 0;
    // Iterate over all pairs (i, j) with 0 <= i < j < nums.length
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] < target) {
                count++;
            }
        }
    }
    return count;
}
;
const input = [-6, 2, 5, -2, -7, -1, 3];
const target = -2;
const results = countPairs(input, target);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
