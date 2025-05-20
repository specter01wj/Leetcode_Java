function numberOfSteps(num) {
    let steps = 0;
    while (num > 0) {
        if (num % 2 === 0) {
            num /= 2;
        }
        else {
            num -= 1;
        }
        steps++;
    }
    return steps;
}
;
const input = 14;
const results = numberOfSteps(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
