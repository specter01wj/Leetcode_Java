function reversePrefix(word: string, ch: string): string {
    const idx = word.indexOf(ch);
    if (idx === -1) return word;

    const reversed = word.slice(0, idx + 1).split('').reverse().join('');
    return reversed + word.slice(idx + 1);
};

const input: string = "abcdefd";
const ch: string = "d";
const results = reversePrefix(input, ch);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

