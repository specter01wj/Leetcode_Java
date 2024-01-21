function minEatingSpeed(piles, h) {
    var left = 1; // minimum possible speed
    var right = Math.max.apply(Math, piles); // maximum possible speed
    while (left < right) {
        var mid = Math.floor((left + right) / 2);
        if (canEatAll(piles, mid, h)) {
            // If she can eat all bananas at this rate, try a smaller speed
            right = mid;
        }
        else {
            // Otherwise, she needs a higher speed
            left = mid + 1;
        }
    }
    return left;
}
;
function canEatAll(piles, speed, h) {
    var hours = 0;
    for (var _i = 0, piles_1 = piles; _i < piles_1.length; _i++) {
        var pile = piles_1[_i];
        hours += Math.ceil(pile / speed);
    }
    return hours <= h;
}
var input1 = [30, 11, 23, 4, 20], h = 5;
var output1 = minEatingSpeed(input1, h);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
