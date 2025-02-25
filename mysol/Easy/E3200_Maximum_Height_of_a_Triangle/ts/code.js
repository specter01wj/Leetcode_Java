function maxHeightOfTriangle(red, blue) {
    return Math.max(buildTriangle(red, blue), buildTriangle(blue, red));
}
;
function buildTriangle(primary, secondary) {
    let height = 0;
    let i = 1; // Number of balls needed for the current row
    while (true) {
        if (i % 2 === 1) { // Odd rows use primary color
            if (primary >= i) {
                primary -= i;
            }
            else {
                break;
            }
        }
        else { // Even rows use secondary color
            if (secondary >= i) {
                secondary -= i;
            }
            else {
                break;
            }
        }
        height++; // Successfully added another row
        i++; // Move to the next row
    }
    return height;
}
const red = 2, blue = 4;
const results = maxHeightOfTriangle(red, blue);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Red: ' + JSON.stringify(red, null, 2) + '; Blue: ' + JSON.stringify(blue, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
