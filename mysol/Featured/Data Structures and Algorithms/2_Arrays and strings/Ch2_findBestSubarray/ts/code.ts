function numSubarrayProductLessThanK(nums: number[], k: number): number {
    if (k <= 1) return 0;

    let ans = 0;
    let left = 0;
    let curr = 1;

    for (let right = 0; right < nums.length; right++) {
        curr *= nums[right];

        while (curr >= k) {
            curr /= nums[left];
            left++;
        }

        ans += right - left + 1;
    }

    return ans;
}


const input: number[] = [10, 5, 2, 6];
const k: number = 100;
const results = numSubarrayProductLessThanK(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

