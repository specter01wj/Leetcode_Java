function canConstruct(ransomNote: string, magazine: string): boolean {
    const count: number[] = new Array(26).fill(0);

    for (const char of magazine) {
        count[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

    for (const char of ransomNote) {
        const index = char.charCodeAt(0) - 'a'.charCodeAt(0);
        if (--count[index] < 0) {
            return false;
        }
    }

    return true;
};

const input: string = "aa";
const magazine: string = "aab";
const results = canConstruct(input, magazine);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

