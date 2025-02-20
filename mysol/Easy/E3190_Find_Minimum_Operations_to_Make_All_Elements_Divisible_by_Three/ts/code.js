function minimumOperations(nums) {
    let count = 0;
    for (let num of nums) {
        if (num % 3 !== 0) {
            count++;
        }
    }
    return count;
}
;
const input = [1, 2, 3, 4];
const results = minimumOperations(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
