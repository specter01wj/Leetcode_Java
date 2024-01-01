function decodeString(s) {
    var counts = [];
    var resultStack = [];
    resultStack.push([]);
    var k = 0;
    for (var _i = 0, s_1 = s; _i < s_1.length; _i++) {
        var ch = s_1[_i];
        if (ch >= '0' && ch <= '9') {
            k = k * 10 + parseInt(ch, 10);
        }
        else if (ch === '[') {
            counts.push(k);
            resultStack.push([]);
            k = 0;
        }
        else if (ch === ']') {
            var temp = resultStack.pop().join('');
            var count = counts.pop();
            resultStack[resultStack.length - 1].push(temp.repeat(count));
        }
        else {
            resultStack[resultStack.length - 1].push(ch);
        }
    }
    return resultStack.pop().join('');
}
;
var input1 = "3[a2[c]]";
var output1 = decodeString(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
