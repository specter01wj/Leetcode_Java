function minOperations(nums, k) {
    const set = new Set();
    for (const num of nums) {
        if (num < k) {
            return -1; // Step 1: Impossible if any number is less than k
        }
        else if (num > k) {
            set.add(num); // Step 2: Track unique values greater than k
        }
    }
    return set.size; // Step 3: Number of operations = number of distinct values > k
}
;
const input = [5, 2, 5, 4, 5];
const k = 2;
const results = minOperations(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
