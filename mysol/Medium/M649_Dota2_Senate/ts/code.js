function predictPartyVictory(senate) {
    var radiant = [];
    var dire = [];
    // Initialize the queues with the indices of the senators
    for (var i = 0; i < senate.length; i++) {
        if (senate[i] === 'R') {
            radiant.push(i);
        }
        else {
            dire.push(i);
        }
    }
    while (radiant.length > 0 && dire.length > 0) {
        var radiantIndex = radiant.shift();
        var direIndex = dire.shift();
        // The senator with the smaller index gets to act first
        if (radiantIndex < direIndex) {
            radiant.push(radiantIndex + senate.length);
        }
        else {
            dire.push(direIndex + senate.length);
        }
    }
    return radiant.length === 0 ? "Dire" : "Radiant";
}
;
var input1 = "RDD";
var output1 = predictPartyVictory(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
