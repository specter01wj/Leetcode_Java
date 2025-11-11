function numSubarraysWithSum(nums, goal) {
    const prefixMap = new Map();
    prefixMap.set(0, 1);
    let sum = 0;
    let count = 0;
    for (let num of nums) {
        sum += num;
        if (prefixMap.has(sum - goal)) {
            count += prefixMap.get(sum - goal);
        }
        prefixMap.set(sum, (prefixMap.get(sum) || 0) + 1);
    }
    return count;
}
;
const input = [1, 0, 1, 0, 1];
const goal = 2;
const results = numSubarraysWithSum(input, goal);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
