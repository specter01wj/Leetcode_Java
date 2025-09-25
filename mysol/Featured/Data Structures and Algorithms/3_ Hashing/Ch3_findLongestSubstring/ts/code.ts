function findLongestSubstring(s: string, k: number): number {
    if (k === 0 || s.length === 0) return 0;

    const map: Map<string, number> = new Map();
    let left = 0;
    let maxLen = 0;

    for (let right = 0; right < s.length; right++) {
        const char = s[right];
        map.set(char, (map.get(char) || 0) + 1);

        while (map.size > k) {
            const leftChar = s[left];
            map.set(leftChar, map.get(leftChar)! - 1);
            if (map.get(leftChar)! === 0) {
                map.delete(leftChar);
            }
            left++;
        }

        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}

const input: string = "eceba";
const k: number = 2;
const results = findLongestSubstring(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

