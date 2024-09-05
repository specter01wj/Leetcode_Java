function findMaxK(nums) {
    let set = new Set();
    let maxK = -1;
    // Add all elements to the set
    for (let num of nums) {
        set.add(num);
    }
    // Check for the largest positive integer k such that -k also exists
    for (let num of nums) {
        if (num > 0 && set.has(-num)) {
            maxK = Math.max(maxK, num);
        }
    }
    return maxK;
}
;
const input = [-1, 10, 6, 7, -7, 1];
const results = findMaxK(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
