function findWinners(matches) {
    const lossCount = new Map();
    const allPlayers = new Set();
    for (const [winner, loser] of matches) {
        lossCount.set(loser, (lossCount.get(loser) || 0) + 1);
        allPlayers.add(winner);
        allPlayers.add(loser);
    }
    const noLoss = [];
    const oneLoss = [];
    for (const player of allPlayers) {
        const losses = lossCount.get(player) || 0;
        if (losses === 0) {
            noLoss.push(player);
        }
        else if (losses === 1) {
            oneLoss.push(player);
        }
    }
    noLoss.sort((a, b) => a - b);
    oneLoss.sort((a, b) => a - b);
    return [noLoss, oneLoss];
}
;
const input = [[1, 3], [2, 3], [3, 6], [5, 6], [5, 7], [4, 5], [4, 8], [4, 9], [10, 4], [10, 9]];
const results = findWinners(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
