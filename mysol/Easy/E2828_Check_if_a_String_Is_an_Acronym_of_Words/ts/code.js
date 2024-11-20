function isAcronym(words, s) {
    // If the lengths do not match, it cannot be an acronym
    if (words.length !== s.length) {
        return false;
    }
    // Build the acronym from the first characters of the words
    let acronym = "";
    for (const word of words) {
        acronym += word[0]; // Add the first character of each word
    }
    // Compare the built acronym with the given string s
    return acronym === s;
}
;
const input = ["never", "gonna", "give", "up", "on", "you"];
const s = "ngguoy";
const results = isAcronym(input, s);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
