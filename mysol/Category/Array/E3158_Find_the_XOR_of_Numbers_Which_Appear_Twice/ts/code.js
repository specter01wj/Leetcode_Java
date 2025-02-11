function duplicateNumbersXOR(nums) {
    const seen = new Set();
    const duplicates = new Set();
    let xor = 0;
    for (const num of nums) {
        if (seen.has(num)) { // If already seen, it's a duplicate
            if (!duplicates.has(num)) { // Ensure we only XOR once per duplicate number
                xor ^= num;
                duplicates.add(num);
            }
        }
        else {
            seen.add(num);
        }
    }
    return xor;
}
;
const input = [1, 2, 2, 1];
const results = duplicateNumbersXOR(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
