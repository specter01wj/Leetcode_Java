function maxStudentsOnBench(students) {
    if (students.length === 0)
        return 0;
    const benchMap = new Map();
    for (const [studentId, benchId] of students) {
        if (!benchMap.has(benchId)) {
            benchMap.set(benchId, new Set());
        }
        benchMap.get(benchId).add(studentId);
    }
    let max = 0;
    for (const studentSet of benchMap.values()) {
        max = Math.max(max, studentSet.size);
    }
    return max;
}
;
const input = [[1, 2], [2, 2], [3, 3], [1, 3], [2, 3]];
const results = maxStudentsOnBench(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
