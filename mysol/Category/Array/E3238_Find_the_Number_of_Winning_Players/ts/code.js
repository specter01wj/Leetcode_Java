function winningPlayerCount(n, pick) {
    let playerMap = new Map();
    // Count the number of balls of each color picked by each player
    for (let [player, color] of pick) {
        if (!playerMap.has(player)) {
            playerMap.set(player, new Map());
        }
        let colorMap = playerMap.get(player);
        colorMap.set(color, (colorMap.get(color) || 0) + 1);
    }
    let count = 0;
    // Check which players meet the winning condition
    for (let [player, colorMap] of playerMap) {
        for (let ballCount of colorMap.values()) {
            if (ballCount > player) {
                count++;
                break; // No need to check further colors for this player
            }
        }
    }
    return count;
}
;
const input = [[0, 0], [1, 0], [1, 0], [2, 1], [2, 1], [2, 0]];
const n = 4;
const results = winningPlayerCount(n, input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
