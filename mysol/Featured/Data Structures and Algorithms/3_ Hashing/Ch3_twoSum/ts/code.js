function twoSum(nums, target) {
    const map = new Map(); // value -> index
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if (map.has(complement)) {
            return [map.get(complement), i]; // non-null assertion
        }
        map.set(nums[i], i);
    }
    return []; // problem guarantees exactly one solution
}
;
const input = [2, 7, 11, 15];
const target = 9;
const results = twoSum(input, target);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
