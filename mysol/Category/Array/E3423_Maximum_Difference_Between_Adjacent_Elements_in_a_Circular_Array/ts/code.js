function maxAdjacentDistance(nums) {
    let maxDiff = 0;
    const n = nums.length;
    for (let i = 0; i < n; i++) {
        const next = (i + 1) % n; // circular index
        const diff = Math.abs(nums[i] - nums[next]);
        maxDiff = Math.max(maxDiff, diff);
    }
    return maxDiff;
}
;
const input = [1, 2, 4];
const results = maxAdjacentDistance(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
