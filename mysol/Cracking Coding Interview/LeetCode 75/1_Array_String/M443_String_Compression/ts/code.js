function compress(chars) {
    var indexAns = 0, index = 0;
    while (index < chars.length) {
        var currentChar = chars[index];
        var count = 0;
        while (index < chars.length && chars[index] === currentChar) {
            index++;
            count++;
        }
        chars[indexAns++] = currentChar;
        if (count !== 1) {
            var countStr = count.toString();
            for (var i = 0; i < countStr.length; i++) {
                chars[indexAns++] = countStr[i];
            }
        }
    }
    return indexAns;
}
;
var input1 = ["a", "a", "b", "b", "c", "c", "c"];
var output1 = compress(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
