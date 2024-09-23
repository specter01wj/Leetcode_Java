function captureForts(forts) {
    let maxCaptured = 0;
    let prev = -1;
    for (let i = 0; i < forts.length; i++) {
        if (forts[i] !== 0) {
            if (prev !== -1 && forts[prev] !== forts[i]) {
                const captured = i - prev - 1;
                if (captured > 0) {
                    maxCaptured = Math.max(maxCaptured, captured);
                }
            }
            prev = i;
        }
    }
    return maxCaptured;
}
;
const input = [1, 0, 0, -1, 0, 0, 0, 0, 1];
const results = captureForts(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;
