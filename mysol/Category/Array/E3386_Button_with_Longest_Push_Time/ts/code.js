function buttonWithLongestTime(events) {
    let longestDuration = events[0][1]; // First button duration
    let buttonIndex = events[0][0]; // First button index
    for (let i = 1; i < events.length; i++) {
        const duration = events[i][1] - events[i - 1][1];
        const currentButton = events[i][0];
        if (duration > longestDuration) {
            longestDuration = duration;
            buttonIndex = currentButton;
        }
        else if (duration === longestDuration && currentButton < buttonIndex) {
            buttonIndex = currentButton;
        }
    }
    return buttonIndex;
}
;
const input = [[1, 2], [2, 5], [3, 9], [1, 15]];
const results = buttonWithLongestTime(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
