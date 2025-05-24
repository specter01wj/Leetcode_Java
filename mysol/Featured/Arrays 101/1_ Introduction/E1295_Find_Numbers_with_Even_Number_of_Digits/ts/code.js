function findNumbers(nums) {
    let count = 0;
    for (let num of nums) {
        if (num.toString().length % 2 === 0) {
            count++;
        }
    }
    return count;
}
;
const input = [12, 345, 2, 6, 7896];
const results = findNumbers(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
