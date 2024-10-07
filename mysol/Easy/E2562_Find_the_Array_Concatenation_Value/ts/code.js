function findTheArrayConcVal(nums) {
    let concatenationValue = 0;
    let left = 0;
    let right = nums.length - 1;
    while (left <= right) {
        if (left === right) {
            concatenationValue += nums[left];
            break;
        }
        else {
            let concat = nums[left].toString() + nums[right].toString();
            concatenationValue += parseInt(concat);
        }
        left++;
        right--;
    }
    return concatenationValue;
}
;
const input = [7, 52, 2, 4];
const results = findTheArrayConcVal(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;
