function intersection(nums) {
    const countMap = new Map();
    const totalArrays = nums.length;
    for (const arr of nums) {
        const unique = new Set(arr);
        for (const num of unique) {
            countMap.set(num, (countMap.get(num) || 0) + 1);
        }
    }
    const result = [];
    for (const [num, count] of countMap) {
        if (count === totalArrays) {
            result.push(num);
        }
    }
    return result.sort((a, b) => a - b);
}
;
const input = [[3, 1, 2, 4, 5], [1, 2, 3, 4], [3, 4, 5, 6]];
const results = intersection(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
