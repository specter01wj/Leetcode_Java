function findBestSubarray(nums: number[], k: number): number {
    let curr = 0;
    for (let i = 0; i < k; i++) {
        curr += nums[i];
    }

    let ans = curr;
    for (let i = k; i < nums.length; i++) {
        curr += nums[i] - nums[i - k];
        ans = Math.max(ans, curr);
    }

    return ans;
}


const input: number[] = [3, -1, 4, 12, -8, 5, 6];
const k: number = 4;
const results = findBestSubarray(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

