function isConsecutive(nums) {
    if (nums == null || nums.length === 0) {
        return false;
    }
    const set = new Set();
    let min = Number.MAX_SAFE_INTEGER;
    let max = Number.MIN_SAFE_INTEGER;
    // Find the minimum and maximum values
    for (const num of nums) {
        if (num < min)
            min = num;
        if (num > max)
            max = num;
        set.add(num);
    }
    // Check if the number of unique elements matches the range
    for (let i = min; i <= max; i++) {
        if (!set.has(i)) {
            return false;
        }
    }
    return (max - min + 1) === nums.length;
}
;
const input = [1, 3, 4, 2];
const results = isConsecutive(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
