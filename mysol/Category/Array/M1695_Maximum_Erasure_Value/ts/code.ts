function maximumUniqueSubarray(nums: number[]): number {
    const seen: Set<number> = new Set();
    let left = 0, currentSum = 0, maxSum = 0;

    for (let right = 0; right < nums.length; right++) {
        while (seen.has(nums[right])) {
            seen.delete(nums[left]);
            currentSum -= nums[left];
            left++;
        }
        seen.add(nums[right]);
        currentSum += nums[right];
        maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
};

const input: number[] = [4,2,4,5,6];
const results = maximumUniqueSubarray(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

