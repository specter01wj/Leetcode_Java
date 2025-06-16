function replaceElements(arr: number[]): number[] {
    let maxRight = -1;

    for (let i = arr.length - 1; i >= 0; i--) {
        const current = arr[i];
        arr[i] = maxRight;
        if (current > maxRight) {
            maxRight = current;
        }
    }

    return arr;
};

const input: number[] = [17,18,5,4,6,1];
const inputCopy: number[] = [...input];
const results = replaceElements(inputCopy);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

