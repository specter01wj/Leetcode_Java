function numOfUnplacedFruits(fruits, baskets) {
    let unplaced = 0;
    for (let i = 0; i < fruits.length; i++) {
        let placed = false;
        for (let j = 0; j < baskets.length; j++) {
            if (baskets[j] >= fruits[i]) {
                baskets[j] = -1; // mark as used
                placed = true;
                break;
            }
        }
        if (!placed) {
            unplaced++;
        }
    }
    return unplaced;
}
;
const fruits = [4, 2, 5], baskets = [3, 5, 4];
const basketsCopy = [...baskets];
const results = numOfUnplacedFruits(fruits, basketsCopy);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'fruits: ' + JSON.stringify(fruits, null, 2) + '; baskets: ' + JSON.stringify(baskets, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
