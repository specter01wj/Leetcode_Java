function badSensor(sensor1, sensor2) {
    let i = 0;
    const sz = sensor1.length;
    // Find the first index where sensor1 and sensor2 differ
    while (i < sz && sensor1[i] === sensor2[i]) {
        ++i;
    }
    // Check if removing one element from sensor1 or sensor2 will make them equal
    while (i + 1 < sz && sensor1[i] === sensor2[i + 1] && sensor1[i + 1] === sensor2[i]) {
        ++i;
    }
    // Return 1 if sensor1 has a defect, 2 if sensor2 has a defect, -1 if neither
    return i >= sz - 1 ? -1 : sensor1[i] === sensor2[i + 1] ? 1 : 2;
}
;
const sensor1 = [2, 3, 4, 5];
const sensor2 = [2, 1, 3, 4];
const results = badSensor(sensor1, sensor2);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input1: ' + sensor1 + '; Input2: ' + sensor2 + '<br>Result = ' + results;
