function minSubArrayLen(target: number, nums: number[]): number {
    let left = 0, sum = 0, minLen = Infinity;

    for (let right = 0; right < nums.length; right++) {
        sum += nums[right];

        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left++];
        }
    }

    return minLen === Infinity ? 0 : minLen;
};

const input: number[] = [2,3,1,2,4,3];
const target: number = 7;
const results = minSubArrayLen(target, input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

