function heightChecker(heights: number[]): number {
    const expected: number[] = [...heights].sort((a, b) => a - b);
    let count = 0;

    for (let i = 0; i < heights.length; i++) {
        if (heights[i] !== expected[i]) {
            count++;
        }
    }

    return count;
};

const input: number[] = [1,1,4,2,1,3];
const results = heightChecker(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

