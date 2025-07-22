function getAverages(nums: number[], k: number): number[] {
    const n = nums.length;
    const ans: number[] = new Array(n).fill(-1);
    if (k === 0) return nums;
    if (2 * k + 1 > n) return ans;

    let windowSum = 0;
    const windowSize = 2 * k + 1;

    for (let i = 0; i < n; i++) {
        windowSum += nums[i];

        if (i >= windowSize - 1) {
            const center = i - k;
            ans[center] = Math.floor(windowSum / windowSize);
            windowSum -= nums[i - windowSize + 1];
        }
    }

    return ans;
};

const input: number[] = [7,4,3,9,1,8,5,2,6];
const k: number = 3;
const results = getAverages(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

