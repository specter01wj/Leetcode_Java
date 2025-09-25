function findNumbers(nums: number[]): number[] {
    const numSet = new Set<number>(nums);
    const result: number[] = [];

    for (const num of numSet) {
        if (!numSet.has(num - 1) && !numSet.has(num + 1)) {
            result.push(num);
        }
    }

    return result;
}

const input: number[] = [1, 2, 4, 5, 7, 7, 9];
const results = findNumbers(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

