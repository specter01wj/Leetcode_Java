function maxNumberOfBalloons(text: string): number {
    const freq: Map<string, number> = new Map();

    for (const char of text) {
        freq.set(char, (freq.get(char) || 0) + 1);
    }

    const b = freq.get('b') || 0;
    const a = freq.get('a') || 0;
    const l = Math.floor((freq.get('l') || 0) / 2);
    const o = Math.floor((freq.get('o') || 0) / 2);
    const n = freq.get('n') || 0;

    return Math.min(b, a, l, o, n);
};

const input: string = "loonbalxballpoon";
const results = maxNumberOfBalloons(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

