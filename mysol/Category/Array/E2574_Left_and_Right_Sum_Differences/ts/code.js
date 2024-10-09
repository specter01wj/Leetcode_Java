function leftRightDifference(nums) {
    const n = nums.length;
    const leftSum = new Array(n).fill(0);
    const rightSum = new Array(n).fill(0);
    const answer = new Array(n).fill(0);
    // Calculate left sums
    for (let i = 1; i < n; i++) {
        leftSum[i] = leftSum[i - 1] + nums[i - 1];
    }
    // Calculate right sums
    for (let i = n - 2; i >= 0; i--) {
        rightSum[i] = rightSum[i + 1] + nums[i + 1];
    }
    // Calculate the answer array
    for (let i = 0; i < n; i++) {
        answer[i] = Math.abs(leftSum[i] - rightSum[i]);
    }
    return answer;
}
;
const input = [10, 4, 8, 3];
const results = leftRightDifference(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
