function findMaxConsecutiveOnes(nums: number[]): number {
    let max = 0;
    let left = 0;
    let zeroCount = 0;

    for (let right = 0; right < nums.length; right++) {
        if (nums[right] === 0) {
            zeroCount++;
        }

        while (zeroCount > 1) {
            if (nums[left] === 0) {
                zeroCount--;
            }
            left++;
        }

        max = Math.max(max, right - left + 1);
    }

    return max;
};

const input: number[] = [1,0,1,1,0];
const results = findMaxConsecutiveOnes(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

