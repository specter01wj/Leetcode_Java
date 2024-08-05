function highFive(items) {
    // Step 1: Create a Map to store student ID and their scores
    const scoresMap = new Map();
    // Step 2: Populate the Map with student IDs and their scores
    for (const [id, score] of items) {
        if (!scoresMap.has(id)) {
            scoresMap.set(id, []);
        }
        scoresMap.get(id).push(score);
    }
    // Step 3: Calculate the top five average for each student
    const result = [];
    for (const [id, scores] of scoresMap) {
        // Sort scores in descending order
        scores.sort((a, b) => b - a);
        // Calculate the sum of the top five scores
        let sum = 0;
        for (let i = 0; i < 5 && i < scores.length; i++) {
            sum += scores[i];
        }
        // Calculate the average using integer division
        const topFiveAverage = Math.floor(sum / 5);
        result.push([id, topFiveAverage]);
    }
    // Step 4: Sort the result by student ID
    result.sort((a, b) => a[0] - b[0]);
    // Step 5: Return the result
    return result;
}
;
const items = [[1, 91], [1, 92], [2, 93], [2, 97], [1, 60], [2, 77], [1, 65], [1, 87], [1, 100], [2, 100], [2, 76]];
const results = highFive(items);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + items + '<br>Result = ' + results;
