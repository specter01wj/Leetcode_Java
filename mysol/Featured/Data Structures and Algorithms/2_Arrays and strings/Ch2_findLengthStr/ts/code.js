function findLengthStr(s) {
    let left = 0;
    let curr = 0;
    let ans = 0;
    for (let right = 0; right < s.length; right++) {
        if (s[right] === '0') {
            curr++;
        }
        while (curr > 1) {
            if (s[left] === '0') {
                curr--;
            }
            left++;
        }
        ans = Math.max(ans, right - left + 1);
    }
    return ans;
}
const input = "1101100111";
const results = findLengthStr(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
