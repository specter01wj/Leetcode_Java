function maxFrequencyElements(nums) {
    const frequencyMap = new Map();
    // Count the frequency of each element in the array
    for (const num of nums) {
        frequencyMap.set(num, (frequencyMap.get(num) || 0) + 1);
    }
    // Find the maximum frequency
    let maxFrequency = 0;
    for (const freq of frequencyMap.values()) {
        maxFrequency = Math.max(maxFrequency, freq);
    }
    // Calculate the total frequencies of elements with maximum frequency
    let totalCount = 0;
    for (const num of nums) {
        if (frequencyMap.get(num) === maxFrequency) {
            totalCount++;
        }
    }
    return totalCount;
}
;
const input = [1, 2, 2, 3, 1, 4];
const results = maxFrequencyElements(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
