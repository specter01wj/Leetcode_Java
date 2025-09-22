function repeatedCharacter(s) {
    const seen = new Set();
    for (const char of s) {
        if (seen.has(char)) {
            return char;
        }
        seen.add(char);
    }
    return '';
}
;
const input = "abccbaacz";
const results = repeatedCharacter(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
