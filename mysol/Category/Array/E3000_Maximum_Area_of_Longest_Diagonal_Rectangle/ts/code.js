function areaOfMaxDiagonal(dimensions) {
    let maxDiagonal = 0;
    let maxArea = 0;
    for (const [length, width] of dimensions) {
        // Calculate the diagonal length using the Pythagorean theorem
        const diagonal = Math.sqrt(length * length + width * width);
        // Calculate the area of the rectangle
        const area = length * width;
        // Update the maximum diagonal and area based on the conditions
        if (diagonal > maxDiagonal || (diagonal === maxDiagonal && area > maxArea)) {
            maxDiagonal = diagonal;
            maxArea = area;
        }
    }
    return maxArea;
}
;
const input = [[9, 3], [8, 6]];
const results = areaOfMaxDiagonal(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
