function waysToSplitArray(nums: number[]): number {
    const n = nums.length;
    const prefix: number[] = new Array(n);
    prefix[0] = nums[0];

    for (let i = 1; i < n; i++) {
        prefix[i] = nums[i] + prefix[i - 1];
    }

    let ans = 0;
    for (let i = 0; i < n - 1; i++) {
        const leftSection = prefix[i];
        const rightSection = prefix[n - 1] - prefix[i];
        if (leftSection >= rightSection) {
            ans++;
        }
    }

    return ans;
}

const input: number[] = [10,4,-8,7];
const results = waysToSplitArray(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

