function isArraySpecial(nums) {
    for (let i = 1; i < nums.length; i++) {
        if ((nums[i] % 2) === (nums[i - 1] % 2)) {
            return false; // Adjacent elements have the same parity
        }
    }
    return true; // All adjacent pairs have different parity
}
;
const input = [2, 1, 4];
const results = isArraySpecial(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
