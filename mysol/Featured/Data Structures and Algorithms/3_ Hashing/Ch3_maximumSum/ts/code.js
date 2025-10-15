function maximumSum(nums) {
    const digitSumToMax = new Map();
    let maxSum = -1;
    for (const num of nums) {
        const digitSum = getDigitSum(num);
        if (digitSumToMax.has(digitSum)) {
            const prevMax = digitSumToMax.get(digitSum);
            maxSum = Math.max(maxSum, prevMax + num);
            digitSumToMax.set(digitSum, Math.max(prevMax, num));
        }
        else {
            digitSumToMax.set(digitSum, num);
        }
    }
    return maxSum;
}
;
const getDigitSum = (num) => {
    let sum = 0;
    while (num > 0) {
        sum += num % 10;
        num = Math.floor(num / 10);
    }
    return sum;
};
const input = [18, 43, 36, 13, 7];
const results = maximumSum(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
