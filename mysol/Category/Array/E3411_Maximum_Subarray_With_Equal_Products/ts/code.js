function maxLength(nums) {
    const n = nums.length;
    let maxLen = 0;
    for (let i = 0; i < n; i++) {
        let product = 1n;
        let gcdVal = 0n;
        let lcmVal = 1n;
        for (let j = i; j < n; j++) {
            const current = BigInt(nums[j]);
            product *= current;
            gcdVal = gcdVal === 0n ? current : gcd(gcdVal, current);
            lcmVal = lcm(current, lcmVal);
            if (product > 10n ** 18n || lcmVal > 10n ** 18n)
                break;
            if (product === gcdVal * lcmVal) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
    }
    return maxLen;
}
;
function gcd(a, b) {
    while (b !== 0n) {
        const temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}
function lcm(a, b) {
    return (a * b) / gcd(a, b);
}
const input = [1, 2, 1, 2, 1, 1, 1];
const results = maxLength(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
