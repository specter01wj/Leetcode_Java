function guessNumber(n) {
    var left = 1;
    var right = n;
    while (left <= right) {
        var mid = Math.floor((left + right) / 2);
        var res = guess(mid);
        if (res === 0) {
            // Correct guess
            return mid;
        }
        else if (res === -1) {
            // The number is lower than the guess
            right = mid - 1;
        }
        else {
            // The number is higher than the guess
            left = mid + 1;
        }
    }
    // Return -1 if the number is not found, although this should not happen in this game.
    return -1;
}
;
var pickedNumber = 10;
function guess(num) {
    if (num > pickedNumber) {
        return -1; // num is higher than the picked number
    }
    else if (num < pickedNumber) {
        return 1; // num is lower than the picked number
    }
    else {
        return 0; // num is equal to the picked number
    }
}
var input1 = 100;
var output1 = guessNumber(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
