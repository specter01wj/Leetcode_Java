function reverseWords(s) {
    return s
        .split(" ")
        .map(word => word.split("").reverse().join(""))
        .join(" ");
}
;
const input = "Let's take LeetCode contest";
const results = reverseWords(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
