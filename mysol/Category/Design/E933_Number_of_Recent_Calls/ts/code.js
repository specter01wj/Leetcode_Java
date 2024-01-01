var RecentCounter = /** @class */ (function () {
    function RecentCounter() {
        this.requests = [];
    }
    RecentCounter.prototype.ping = function (t) {
        this.requests.push(t);
        // Remove older requests outside the 3000ms window
        while (this.requests.length > 0 && this.requests[0] < t - 3000) {
            this.requests.shift();
        }
        // Return the number of requests in the window
        return this.requests.length;
    };
    return RecentCounter;
}());
var obj = new RecentCounter();
var input1 = 100;
var param_1 = obj.ping(input1);
// let output1 = decodeString(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(param_1);
