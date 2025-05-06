function totalNumbers(digits) {
    const uniqueNumbers = new Set();
    const n = digits.length;
    for (let i = 0; i < n; i++) {
        if (digits[i] === 0)
            continue; // Hundreds place can't be zero
        for (let j = 0; j < n; j++) {
            if (j === i)
                continue;
            for (let k = 0; k < n; k++) {
                if (k === i || k === j)
                    continue;
                const num = digits[i] * 100 + digits[j] * 10 + digits[k];
                if (num % 2 === 0) {
                    uniqueNumbers.add(num);
                }
            }
        }
    }
    return uniqueNumbers.size;
}
;
const input = [1, 2, 3, 4];
const results = totalNumbers(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
