function maxVowels(s, k) {
    var maxVowels = 0;
    var currentVowels = 0;
    // Count vowels in the first window
    for (var i = 0; i < k; i++) {
        if (isVowel(s[i])) {
            currentVowels++;
        }
    }
    maxVowels = currentVowels;
    // Slide the window and update the count
    for (var i = k; i < s.length; i++) {
        if (isVowel(s[i])) {
            currentVowels++;
        }
        if (isVowel(s[i - k])) {
            currentVowels--;
        }
        maxVowels = Math.max(maxVowels, currentVowels);
    }
    return maxVowels;
}
;
// Function to check if a character is a vowel
function isVowel(ch) {
    return 'aeiou'.includes(ch);
}
var input1 = "abciiidef", k = 3;
var output1 = maxVowels(input1, 4);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
