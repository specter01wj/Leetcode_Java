function reverseOnlyLetters(s) {
    const chars = s.split('');
    let left = 0, right = chars.length - 1;
    while (left < right) {
        if (!/[a-zA-Z]/.test(chars[left])) {
            left++;
        }
        else if (!/[a-zA-Z]/.test(chars[right])) {
            right--;
        }
        else {
            [chars[left], chars[right]] = [chars[right], chars[left]];
            left++;
            right--;
        }
    }
    return chars.join('');
}
;
const input = "Test1ng-Leet=code-Q!";
const results = reverseOnlyLetters(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
