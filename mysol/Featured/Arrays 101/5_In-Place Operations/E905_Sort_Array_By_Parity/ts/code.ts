function sortArrayByParity(nums: number[]): number[] {
    let left = 0, right = nums.length - 1;

    while (left < right) {
        if (nums[left] % 2 > nums[right] % 2) {
            [nums[left], nums[right]] = [nums[right], nums[left]];
        }

        if (nums[left] % 2 === 0) left++;
        if (nums[right] % 2 === 1) right--;
    }

    return nums;
};

const input: number[] = [3,1,2,4];
const inputCopy = [...input];
const results = sortArrayByParity(inputCopy);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

