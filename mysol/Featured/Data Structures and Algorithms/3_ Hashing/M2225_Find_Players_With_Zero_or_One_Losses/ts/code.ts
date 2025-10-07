function checkIfPangram(sentence: string): boolean {
    const seen: Set<string> = new Set();

    for (const char of sentence) {
        seen.add(char);
    }

    return seen.size === 26;
}

const input: string = "thequickbrownfoxjumpsoverthelazydog";
const results = checkIfPangram(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

