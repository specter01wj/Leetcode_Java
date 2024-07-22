class StringIterator {
    constructor(compressedString) {
        this.compressedString = compressedString;
        this.index = 0;
        this.count = 0;
        this.currentChar = ' ';
        // Initialize the first character and its count
        if (this.compressedString.length > 0) {
            this.currentChar = this.compressedString.charAt(this.index++);
            while (this.index < this.compressedString.length && !isNaN(parseInt(this.compressedString.charAt(this.index)))) {
                this.count = this.count * 10 + parseInt(this.compressedString.charAt(this.index++));
            }
        }
    }
    next() {
        if (this.count === 0) {
            if (this.index >= this.compressedString.length) {
                return ' ';
            }
            this.currentChar = this.compressedString.charAt(this.index++);
            this.count = 0;
            while (this.index < this.compressedString.length && !isNaN(parseInt(this.compressedString.charAt(this.index)))) {
                this.count = this.count * 10 + parseInt(this.compressedString.charAt(this.index++));
            }
        }
        this.count--;
        return this.currentChar;
    }
    hasNext() {
        return this.count > 0 || this.index < this.compressedString.length;
    }
}
let input = "L1e2t1C1o1d1e1";
const obj = new StringIterator(input);
let results = [];
results.push('next: ' + obj.next()); // Output: "L"
results.push('next: ' + obj.next()); // Output: "e"
results.push('next: ' + obj.next()); // Output: "e"
results.push('next: ' + obj.next()); // Output: "t"
results.push('next: ' + obj.next()); // Output: "C"
results.push('next: ' + obj.next()); // Output: "o"
results.push('hasNext: ' + obj.hasNext()); // Output: true
results.push('next: ' + obj.next()); // Output: "d"
results.push('hasNext: ' + obj.hasNext()); // Output: true
results.push('next: ' + obj.next()); // Output: "e"
results.push('hasNext: ' + obj.hasNext()); // Output: false
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
