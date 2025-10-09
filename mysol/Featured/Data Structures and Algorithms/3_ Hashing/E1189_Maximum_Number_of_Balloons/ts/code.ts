function largestUniqueNumber(nums: number[]): number {
    const freq = new Map<number, number>();

    for (const num of nums) {
        freq.set(num, (freq.get(num) || 0) + 1);
    }

    let max = -1;
    for (const [num, count] of freq) {
        if (count === 1 && num > max) {
            max = num;
        }
    }

    return max;
};

const input: number[] = [5,7,3,9,4,9,8,3,1];
const results = largestUniqueNumber(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

