function minStartValue(nums: number[]): number {
    let sum = 0;
    let minSum = 0;

    for (let num of nums) {
        sum += num;
        minSum = Math.min(minSum, sum);
    }

    return 1 - minSum;
};

const input: number[] = [-3,2,-3,4,2];
const results = minStartValue(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

