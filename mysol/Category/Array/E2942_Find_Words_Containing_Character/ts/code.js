function findWordsContaining(words, x) {
    const result = [];
    for (let i = 0; i < words.length; i++) {
        if (words[i].includes(x)) { // Check if the character x exists in the current word
            result.push(i); // Add the index to the result array
        }
    }
    return result; // Return the array of indices
}
;
const input = ["abc", "bcd", "aaaa", "cbc"];
const x = "a";
const results = findWordsContaining(input, x);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
