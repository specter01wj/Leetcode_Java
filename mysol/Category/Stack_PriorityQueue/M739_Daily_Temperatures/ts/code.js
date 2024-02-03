function dailyTemperatures(temperatures) {
    var answer = new Array(temperatures.length).fill(0);
    var stack = []; // This stack will store indices
    for (var i = 0; i < temperatures.length; i++) {
        // Check if current temperature is higher than the last stacked temperature
        while (stack.length !== 0 && temperatures[i] > temperatures[stack[stack.length - 1]]) {
            var index = stack.pop();
            answer[index] = i - index;
        }
        stack.push(i);
    }
    return answer;
}
;
var input1 = [73, 74, 75, 71, 69, 72, 76, 73];
var output1 = dailyTemperatures(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
