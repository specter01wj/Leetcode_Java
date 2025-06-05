function removeDuplicates(nums) {
    if (nums.length === 0)
        return 0;
    let k = 1;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] !== nums[k - 1]) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
}
;
const input = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
const inputCopy = [...input];
const results = removeDuplicates(inputCopy);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
