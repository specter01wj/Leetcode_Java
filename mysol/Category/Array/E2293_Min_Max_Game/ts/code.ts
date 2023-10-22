
function removeAnagrams(words: string[]): string[] {
    let i = 1; // start from the second word
    while (i < words.length) {
        if (areAnagrams(words[i], words[i - 1])) {
            // remove word at position i
            words.splice(i, 1);
        } else {
            i++;
        }
    }
    return words;
}

function areAnagrams(s1: string, s2: string): boolean {
    return sortString(s1) === sortString(s2);
}

function sortString(str: string): string {
    return str.split('').sort().join('');
}


let input = ["abba","baba","bbaa","cd","cd"];
let output = removeAnagrams(input);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


