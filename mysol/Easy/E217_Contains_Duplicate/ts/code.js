function containsDuplicate(nums) {
    const seen = new Set();
    for (const num of nums) {
        if (seen.has(num)) {
            return true; // Duplicate found
        }
        seen.add(num);
    }
    return false; // All elements are unique
}
;
const input = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2];
const results = containsDuplicate(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
