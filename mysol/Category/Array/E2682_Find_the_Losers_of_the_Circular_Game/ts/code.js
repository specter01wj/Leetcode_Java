function countSeniors(details) {
    let seniorCount = 0;
    // Iterate through each passenger's details
    details.forEach((detail) => {
        // Extract the age portion from the string (11th and 12th characters)
        const age = parseInt(detail.substring(11, 13), 10);
        // Check if the age is strictly more than 60
        if (age > 60) {
            seniorCount++;
        }
    });
    return seniorCount;
}
;
const input = ["7868190130M7522", "5303914400F9211", "9273338290F4010"];
const results = countSeniors(input);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
