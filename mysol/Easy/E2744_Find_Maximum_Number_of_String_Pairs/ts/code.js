function maximumNumberOfStringPairs(words) {
    let pairs = 0;
    const unmatchedWords = new Set();
    for (let word of words) {
        const reversedWord = word.split('').reverse().join('');
        // Check if the reversed word is already in the set
        if (unmatchedWords.has(reversedWord)) {
            pairs++;
            unmatchedWords.delete(reversedWord); // Pair found, remove the reversed word
        }
        else {
            unmatchedWords.add(word); // Add the word to unmatched set
        }
    }
    return pairs;
}
;
const input = ["cd", "ac", "dc", "ca", "zz"];
const results = maximumNumberOfStringPairs(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
