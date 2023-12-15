function kidsWithCandies(candies, extraCandies) {
    var ans = [];
    var max = Math.max.apply(Math, candies);
    for (var _i = 0, candies_1 = candies; _i < candies_1.length; _i++) {
        var candy = candies_1[_i];
        ans.push(candy + extraCandies >= max);
    }
    return ans;
}
;
var input = [2, 3, 5, 1, 3], extraCandies = 3;
var output1 = kidsWithCandies(input, extraCandies);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
