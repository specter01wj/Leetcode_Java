function thirdMax(nums) {
    let first = null;
    let second = null;
    let third = null;
    for (const num of nums) {
        if (num === first || num === second || num === third)
            continue;
        if (first === null || num > first) {
            third = second;
            second = first;
            first = num;
        }
        else if (second === null || num > second) {
            third = second;
            second = num;
        }
        else if (third === null || num > third) {
            third = num;
        }
    }
    return third !== null ? third : first;
}
;
const input = [2, 2, 3, 1];
const results = thirdMax(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
