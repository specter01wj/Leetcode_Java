function constructTransformedArray(nums) {
    const n = nums.length;
    const result = new Array(n);
    for (let i = 0; i < n; i++) {
        const steps = nums[i];
        if (steps === 0) {
            result[i] = nums[i];
        }
        else {
            let newIndex = (i + steps) % n;
            if (newIndex < 0) {
                newIndex += n;
            }
            result[i] = nums[newIndex];
        }
    }
    return result;
}
;
const input = [3, -2, 1, 1];
const results = constructTransformedArray(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
