function largestAltitude(gain: number[]): number {
    let maxAltitude = 0;
    let current = 0;

    for (let g of gain) {
        current += g;
        maxAltitude = Math.max(maxAltitude, current);
    }

    return maxAltitude;
};

const input: number[] = [-5,1,5,0,-7];
const results = largestAltitude(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

