function oddString(words) {
    const n = words.length;
    const diffs = [];
    // Compute the difference array for each word
    for (let i = 0; i < n; i++) {
        diffs.push(computeDifferenceArray(words[i]));
    }
    // Find the unique difference array
    for (let i = 0; i < n; i++) {
        // Check if the difference array is unique
        if (!areEqual(diffs[i], diffs[(i + 1) % n]) && !areEqual(diffs[i], diffs[(i + 2) % n])) {
            return words[i];
        }
    }
    return words[0];
}
;
// Helper function to compute the difference array
function computeDifferenceArray(word) {
    const n = word.length;
    const diff = [];
    for (let i = 0; i < n - 1; i++) {
        diff.push(word.charCodeAt(i + 1) - word.charCodeAt(i));
    }
    return diff;
}
// Helper function to check if two arrays are equal
function areEqual(arr1, arr2) {
    if (arr1.length !== arr2.length)
        return false;
    for (let i = 0; i < arr1.length; i++) {
        if (arr1[i] !== arr2[i])
            return false;
    }
    return true;
}
const input = ["adc", "wzy", "abc"];
const results = oddString(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
