function equalSubstring(s, t, maxCost) {
    let left = 0, cost = 0, maxLen = 0;
    for (let right = 0; right < s.length; right++) {
        cost += Math.abs(s.charCodeAt(right) - t.charCodeAt(right));
        while (cost > maxCost) {
            cost -= Math.abs(s.charCodeAt(left) - t.charCodeAt(left));
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
;
const s = "abcd", t = "bcdf";
const maxCost = 3;
const results = equalSubstring(s, t, maxCost);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input s: ' + JSON.stringify(s, null, 2) + '; Input t: ' + JSON.stringify(t, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
