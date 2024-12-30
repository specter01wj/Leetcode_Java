function missingInteger(nums) {
    // Find the longest sequential prefix and its sum
    let sum = nums[0];
    let longestSequentialEnd = 0;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === nums[i - 1] + 1) {
            sum += nums[i];
            longestSequentialEnd = i;
        }
        else {
            break;
        }
    }
    // Find the smallest integer missing from nums that is >= sum
    let x = sum;
    while (true) {
        if (!nums.includes(x)) {
            return x;
        }
        x++;
    }
}
;
const input = [1, 2, 3, 2, 5];
const results = missingInteger(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
