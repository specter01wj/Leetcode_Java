function maximumCount(nums) {
    let pos = 0;
    let neg = 0;
    // Iterate through the array and count positive and negative integers
    for (let num of nums) {
        if (num > 0) {
            pos++;
        }
        else if (num < 0) {
            neg++;
        }
    }
    // Return the maximum count between positive and negative integers
    return Math.max(pos, neg);
}
;
const input = [-2, -1, -1, 1, 2, 3];
const results = maximumCount(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;
