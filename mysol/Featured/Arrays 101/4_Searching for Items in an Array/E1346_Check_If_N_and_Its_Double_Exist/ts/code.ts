function checkIfExist(arr: number[]): boolean {
    const seen = new Set<number>();
    for (const num of arr) {
        if (seen.has(2 * num) || (num % 2 === 0 && seen.has(num / 2))) {
            return true;
        }
        seen.add(num);
    }
    return false;
};

const input: number[] = [10,2,5,3];
const results = checkIfExist(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

