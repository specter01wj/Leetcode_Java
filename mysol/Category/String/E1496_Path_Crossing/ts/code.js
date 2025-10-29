function isPathCrossing(path) {
    const visited = new Set();
    let x = 0, y = 0;
    visited.add("0,0");
    for (const dir of path) {
        if (dir === 'N')
            y++;
        else if (dir === 'S')
            y--;
        else if (dir === 'E')
            x++;
        else if (dir === 'W')
            x--;
        const key = `${x},${y}`;
        if (visited.has(key))
            return true;
        visited.add(key);
    }
    return false;
}
;
const input = "NESWW";
const results = isPathCrossing(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
