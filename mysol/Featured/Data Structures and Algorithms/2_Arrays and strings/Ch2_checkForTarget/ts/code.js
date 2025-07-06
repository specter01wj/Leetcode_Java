function checkForTarget(nums, target) {
    let left = 0;
    let right = nums.length - 1;
    while (left < right) {
        // curr is the current sum
        let curr = nums[left] + nums[right];
        if (curr == target) {
            return true;
        }
        if (curr > target) {
            right--;
        }
        else {
            left++;
        }
    }
    return false;
}
const input = [1, 2, 4, 6, 8, 9, 14, 15];
const target = 13;
const results = checkForTarget(input, target);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
