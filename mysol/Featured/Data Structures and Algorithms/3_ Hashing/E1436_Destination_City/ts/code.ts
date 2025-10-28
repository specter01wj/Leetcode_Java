function countElements(arr: number[]): number {
    const set = new Set<number>(arr);
    let count = 0;

    for (const num of arr) {
        if (set.has(num + 1)) {
            count++;
        }
    }

    return count;
};

const input: number[] = [1,2,3];
const results = countElements(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

