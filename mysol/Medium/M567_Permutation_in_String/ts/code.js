function checkInclusion(s1, s2) {
    if (s1.length > s2.length)
        return false;
    const s1Map = new Map();
    const windowMap = new Map();
    for (const c of s1) {
        s1Map.set(c, (s1Map.get(c) || 0) + 1);
    }
    let left = 0, right = 0;
    while (right < s2.length) {
        const curr = s2[right];
        windowMap.set(curr, (windowMap.get(curr) || 0) + 1);
        right++;
        if (right - left > s1.length) {
            const leftChar = s2[left];
            windowMap.set(leftChar, windowMap.get(leftChar) - 1);
            if (windowMap.get(leftChar) === 0) {
                windowMap.delete(leftChar);
            }
            left++;
        }
        if (mapsAreEqual(s1Map, windowMap))
            return true;
    }
    return false;
}
;
function mapsAreEqual(map1, map2) {
    if (map1.size !== map2.size)
        return false;
    for (const [key, val] of map1) {
        if (map2.get(key) !== val)
            return false;
    }
    return true;
}
const input = "ab", s2 = "eidbaooo";
const results = checkInclusion(input, s2);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
