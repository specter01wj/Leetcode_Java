function maxFrequencyElements(nums) {
    const freqMap = new Map();
    let maxFreq = 0;
    let sum = 0;
    for (const num of nums) {
        const freq = (freqMap.get(num) || 0) + 1;
        freqMap.set(num, freq);
        if (freq > maxFreq) {
            maxFreq = freq;
        }
    }
    for (const freq of freqMap.values()) {
        if (freq === maxFreq) {
            sum += freq;
        }
    }
    return sum;
}
;
const input = [1, 2, 2, 3, 1, 4];
const results = maxFrequencyElements(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
