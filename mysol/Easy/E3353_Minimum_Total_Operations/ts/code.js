function minOperations(nums) {
    let operations = 0;
    for (let i = nums.length - 2; i >= 0; i--) {
        if (nums[i] !== nums[i + 1]) {
            operations++;
        }
    }
    return operations;
}
;
const input = [1, 4, 2];
const results = minOperations(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
