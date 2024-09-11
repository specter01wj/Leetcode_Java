function averageValue(nums) {
    let sum = 0;
    let count = 0;
    // Iterate through the array to find even numbers divisible by 3
    for (let num of nums) {
        if (num % 2 === 0 && num % 3 === 0) {
            sum += num;
            count++;
        }
    }
    // Return the average (rounded down) or 0 if no such numbers found
    return count > 0 ? Math.floor(sum / count) : 0;
}
;
const input = [1, 3, 6, 10, 12, 15];
const results = averageValue(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
