function sortedSquares(nums) {
    const n = nums.length;
    const result = new Array(n);
    let left = 0, right = n - 1;
    let pos = n - 1;
    while (left <= right) {
        const leftSquare = nums[left] * nums[left];
        const rightSquare = nums[right] * nums[right];
        if (leftSquare > rightSquare) {
            result[pos--] = leftSquare;
            left++;
        }
        else {
            result[pos--] = rightSquare;
            right--;
        }
    }
    return result;
}
;
const input = [-4, -1, 0, 3, 10];
const results = sortedSquares(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
