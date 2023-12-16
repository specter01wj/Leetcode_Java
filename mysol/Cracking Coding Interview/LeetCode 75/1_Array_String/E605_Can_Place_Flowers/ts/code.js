function canPlaceFlowers(flowerbed, n) {
    var count = 0;
    for (var i = 0; i < flowerbed.length; i++) {
        if (flowerbed[i] === 0 && (i === 0 || flowerbed[i - 1] === 0)
            && (i === flowerbed.length - 1 || flowerbed[i + 1] === 0)) {
            flowerbed[i] = 1;
            count++;
        }
        if (count >= n) {
            return true;
        }
    }
    return false;
}
;
var input1 = [1, 0, 0, 0, 1], n1 = 1;
var input2 = [1, 0, 0, 0, 1], n2 = 2;
var output1 = canPlaceFlowers(input1, n1);
var output2 = canPlaceFlowers(input2, n2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();
var webHeading2 = document.querySelector('#t2');
webHeading2.textContent = 'Output: ' + output2.toString();
