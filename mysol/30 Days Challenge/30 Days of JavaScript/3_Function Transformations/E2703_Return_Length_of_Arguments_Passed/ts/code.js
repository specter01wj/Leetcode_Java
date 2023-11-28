function argumentsLength() {
    var args = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        args[_i] = arguments[_i];
    }
    return args.length;
}
var output = argumentsLength({}, null, "3");
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output.toString();
