function bestHand(ranks, suits) {
    var cnt = new Array(14).fill(0);
    var max = 0;
    for (var _i = 0, ranks_1 = ranks; _i < ranks_1.length; _i++) {
        var rank = ranks_1[_i];
        cnt[rank]++;
        if (cnt[rank] > max) {
            max = cnt[rank];
        }
    }
    if (suits[0] === suits[1] && suits[1] === suits[2] && suits[2] === suits[3] && suits[3] === suits[4]) {
        return "Flush";
    }
    if (max >= 3) {
        return "Three of a Kind";
    }
    else if (max == 2) {
        return "Pair";
    }
    else {
        return "High Card";
    }
}
var input = [13, 2, 3, 1, 9];
var suits = ["a", "a", "a", "a", "a"];
var output = bestHand(input, suits);
var webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();
