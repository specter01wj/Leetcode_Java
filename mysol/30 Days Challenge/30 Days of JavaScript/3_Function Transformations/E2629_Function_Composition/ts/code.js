function compose(functions) {
    return function (x) {
        return functions.reduceRight(function (acc, func) { return func(acc); }, x);
    };
}
var fn = compose([function (x) { return x + 1; }, function (x) { return 2 * x; }]);
var output1 = fn(4);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
