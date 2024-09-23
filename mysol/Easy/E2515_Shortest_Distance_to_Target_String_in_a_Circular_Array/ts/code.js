function closetTarget(words, target, startIndex) {
    const n = words.length;
    let minDistance = Number.MAX_SAFE_INTEGER;
    for (let i = 0; i < n; i++) {
        if (words[i] === target) {
            // Calculate the distance moving forward
            const forwardDistance = (i - startIndex + n) % n;
            // Calculate the distance moving backward
            const backwardDistance = (startIndex - i + n) % n;
            // Choose the minimum distance
            const distance = Math.min(forwardDistance, backwardDistance);
            // Update the minimum distance found so far
            minDistance = Math.min(minDistance, distance);
        }
    }
    // If the target is not found, return -1
    return minDistance === Number.MAX_SAFE_INTEGER ? -1 : minDistance;
}
;
const input = ["hello", "i", "am", "leetcode", "hello"];
const target = "hello";
const startIndex = 1;
const results = closetTarget(input, target, startIndex);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;
