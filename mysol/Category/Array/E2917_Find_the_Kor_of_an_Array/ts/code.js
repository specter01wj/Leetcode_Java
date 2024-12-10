function findKOr(nums, k) {
    let result = 0;
    // Iterate over each bit position (0 to 31 for a 32-bit integer)
    for (let bit = 0; bit < 32; bit++) {
        let count = 0;
        // Count how many numbers have the current bit set
        for (let num of nums) {
            if ((num & (1 << bit)) !== 0) {
                count++;
            }
        }
        // If the bit is set in at least k numbers, set it in the result
        if (count >= k) {
            result |= (1 << bit);
        }
    }
    return result;
}
;
const input = [7, 12, 9, 8, 9, 15];
const k = 4;
const results = findKOr(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
