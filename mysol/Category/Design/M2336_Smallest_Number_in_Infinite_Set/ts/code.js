var SmallestInfiniteSet = /** @class */ (function () {
    function SmallestInfiniteSet() {
        this.available = new Set();
        this.nextSmallest = 1;
    }
    SmallestInfiniteSet.prototype.popSmallest = function () {
        // Check if there's a number in the available set smaller than nextSmallest
        if (this.available.size > 0 && Math.min.apply(Math, this.available) < this.nextSmallest) {
            var smallestAvailable = Math.min.apply(Math, this.available);
            this.available.delete(smallestAvailable);
            return smallestAvailable;
        }
        // Otherwise, return the nextSmallest number and increment it
        return this.nextSmallest++;
    };
    SmallestInfiniteSet.prototype.addBack = function (num) {
        // Add the number back only if it's smaller than the nextSmallest
        if (num < this.nextSmallest) {
            this.available.add(num);
        }
    };
    return SmallestInfiniteSet;
}());
var actions = ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"];
var parameters = [[], [2], [], [], [], [1], [], [], []];
var results = [];
var set = new SmallestInfiniteSet();
actions.forEach(function (action, index) {
    if (action === "addBack") {
        set.addBack(parameters[index][0]);
        results.push(null);
    }
    else if (action === "popSmallest") {
        results.push(set.popSmallest());
    }
    else {
        results.push(null);
    }
});
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(results);
