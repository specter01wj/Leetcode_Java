function numberOfEmployeesWhoMetTarget(hours, target) {
    let count = 0;
    for (const hour of hours) {
        if (hour >= target) {
            count++;
        }
    }
    return count;
}
;
const input = [0, 1, 2, 3, 4];
const target = 2;
const results = numberOfEmployeesWhoMetTarget(input, target);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
