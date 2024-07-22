function areSentencesSimilar(sentence1, sentence2, similarPairs) {
    // Check if the sentences have the same length
    if (sentence1.length !== sentence2.length) {
        return false;
    }
    // Create a map to store similar pairs
    const similarMap = new Map();
    // Populate the map with the similar pairs
    for (let pair of similarPairs) {
        if (!similarMap.has(pair[0])) {
            similarMap.set(pair[0], new Set());
        }
        similarMap.get(pair[0]).add(pair[1]);
        if (!similarMap.has(pair[1])) {
            similarMap.set(pair[1], new Set());
        }
        similarMap.get(pair[1]).add(pair[0]);
    }
    // Check each word pair in the sentences
    for (let i = 0; i < sentence1.length; i++) {
        const word1 = sentence1[i];
        const word2 = sentence2[i];
        // A word is always similar to itself
        if (word1 === word2) {
            continue;
        }
        // Check if the words are similar according to the map
        if (!(similarMap.has(word1) && similarMap.get(word1).has(word2)) &&
            !(similarMap.has(word2) && similarMap.get(word2).has(word1))) {
            return false;
        }
    }
    // All words are similar
    return true;
}
;
const sentence1 = ["great", "acting", "skills"];
const sentence2 = ["fine", "drama", "talent"];
const similarPairs = [
    ["great", "fine"],
    ["drama", "acting"],
    ["skills", "talent"]
];
const results = areSentencesSimilar(sentence1, sentence2, similarPairs);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + sentence1 + ' and ' + sentence2 + '<br>Result = ' + results;
