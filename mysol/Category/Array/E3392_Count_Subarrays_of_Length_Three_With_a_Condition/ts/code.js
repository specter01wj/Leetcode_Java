function countSubarrays(nums) {
    let count = 0;
    for (let i = 1; i < nums.length - 1; i++) {
        const first = nums[i - 1];
        const mid = nums[i];
        const third = nums[i + 1];
        if ((first + third) * 2 === mid) {
            count++;
        }
    }
    return count;
}
;
const input = [1, 2, 1, 4, 1];
const results = countSubarrays(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
