function minOperations(nums, k) {
    let sum = 0;
    for (let num of nums) {
        sum += num;
    }
    const remainder = sum % k;
    return remainder === 0 ? 0 : remainder;
}
;
const input = [3, 9, 7];
const k = 5;
const results = minOperations(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
