Array.prototype.groupBy = function (fn) {
    var grouped = {};
    for (var i = 0; i < this.length; i++) {
        var key = fn(this[i]);
        if (!grouped[key]) {
            grouped[key] = [];
        }
        grouped[key].push(this[i]);
    }
    return grouped;
};
var input1 = [
    { "id": "1" },
    { "id": "1" },
    { "id": "2" }
];
var fn = function (item) {
    return item.id;
};
var output1 = [1, 2, 3].groupBy(String);
var output2 = input1.groupBy(fn);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + JSON.stringify(output2);
