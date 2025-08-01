function maxVowels(s, k) {
    let count = 0, max = 0;
    const isVowel = (ch) => "aeiou".includes(ch);
    for (let i = 0; i < s.length; i++) {
        if (isVowel(s[i]))
            count++;
        if (i >= k && isVowel(s[i - k]))
            count--;
        max = Math.max(max, count);
    }
    return max;
}
;
const input = "abciiidef";
const k = 4;
const results = maxVowels(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
