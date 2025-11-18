function wordPattern(pattern, s) {
    const words = s.split(" ");
    if (words.length !== pattern.length)
        return false;
    const charToWord = new Map();
    const wordToChar = new Map();
    for (let i = 0; i < pattern.length; i++) {
        const c = pattern[i];
        const word = words[i];
        if (charToWord.has(c)) {
            if (charToWord.get(c) !== word)
                return false;
        }
        else {
            charToWord.set(c, word);
        }
        if (wordToChar.has(word)) {
            if (wordToChar.get(word) !== c)
                return false;
        }
        else {
            wordToChar.set(word, c);
        }
    }
    return true;
}
;
const input = "abba", s = "dog cat cat dog";
const results = wordPattern(input, s);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
