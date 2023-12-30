function removeStars(s) {
    var stack = [];
    for (var _i = 0, s_1 = s; _i < s_1.length; _i++) {
        var ch = s_1[_i];
        if (ch === '*') {
            stack.pop();
        }
        else {
            stack.push(ch);
        }
    }
    return stack.join('');
}
;
var input1 = "leet**cod*e";
var output1 = removeStars(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
