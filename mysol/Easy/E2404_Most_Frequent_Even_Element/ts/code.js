function mostFrequentEven(nums) {
    // Map to store the frequency of even numbers
    const frequencyMap = {};
    // Traverse through the array and count frequencies of even numbers
    for (let num of nums) {
        if (num % 2 === 0) {
            frequencyMap[num] = (frequencyMap[num] || 0) + 1;
        }
    }
    // Variables to track the most frequent even number and its frequency
    let mostFrequentEven = -1;
    let maxFrequency = 0;
    // Traverse through the map to find the most frequent even number
    for (let num in frequencyMap) {
        const freq = frequencyMap[num];
        // Convert num to a number before comparison
        const numValue = parseInt(num);
        // Update the most frequent even number based on frequency and value
        if (freq > maxFrequency || (freq === maxFrequency && numValue < mostFrequentEven)) {
            mostFrequentEven = numValue;
            maxFrequency = freq;
        }
    }
    return mostFrequentEven;
}
;
const input = [0, 1, 2, 2, 4, 4, 1];
const results = mostFrequentEven(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
