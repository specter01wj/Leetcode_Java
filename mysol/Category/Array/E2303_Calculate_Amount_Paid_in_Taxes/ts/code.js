function calculateTax(brackets, income) {
    var tax = 0;
    var prev = 0;
    for (var _i = 0, brackets_1 = brackets; _i < brackets_1.length; _i++) {
        var bracket = brackets_1[_i];
        var upper = bracket[0], percent = bracket[1];
        if (income >= upper) {
            tax += (upper - prev) * percent / 100;
            prev = upper;
        }
        else {
            tax += (income - prev) * percent / 100;
            return tax;
        }
    }
    return tax;
}
var input = [[3, 50], [7, 10], [12, 25]];
var output = calculateTax(input, 10);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
