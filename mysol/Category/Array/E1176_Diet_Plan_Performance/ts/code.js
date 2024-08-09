function dietPlanPerformance(calories, k, lower, upper) {
    let points = 0;
    let currentSum = 0;
    // Calculate the sum for the first window of size k
    for (let i = 0; i < k; i++) {
        currentSum += calories[i];
    }
    // Evaluate the first window
    if (currentSum < lower) {
        points--;
    }
    else if (currentSum > upper) {
        points++;
    }
    // Slide the window over the array
    for (let i = k; i < calories.length; i++) {
        currentSum += calories[i] - calories[i - k];
        if (currentSum < lower) {
            points--;
        }
        else if (currentSum > upper) {
            points++;
        }
    }
    return points;
}
;
const input = [1, 2, 3, 4, 5];
const k = 1, lower = 3, upper = 3;
const results = dietPlanPerformance(input, k, lower, upper);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
