function missingNumber(nums) {
    const numSet = new Set(nums);
    const n = nums.length;
    for (let i = 0; i <= n; i++) {
        if (!numSet.has(i)) {
            return i;
        }
    }
    return -1;
}
;
const input = [9, 6, 4, 2, 3, 5, 7, 0, 1];
const results = missingNumber(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
