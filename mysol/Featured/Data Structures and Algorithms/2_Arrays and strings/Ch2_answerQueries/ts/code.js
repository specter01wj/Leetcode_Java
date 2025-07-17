function findLength(nums, k) {
    let left = 0;
    let curr = 0;
    let ans = 0;
    for (let right = 0; right < nums.length; right++) {
        curr += nums[right];
        while (curr > k) {
            curr -= nums[left];
            left++;
        }
        ans = Math.max(ans, right - left + 1);
    }
    return ans;
}
const input = [3, 1, 2, 7, 4, 2, 1, 1, 5];
const k = 8;
const results = findLength(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
