function predictPartyVictory(senate) {
    const radiant = [];
    const dire = [];
    const n = senate.length;
    for (let i = 0; i < n; i++) {
        if (senate[i] === "R") {
            radiant.push(i);
        }
        else {
            dire.push(i);
        }
    }
    while (radiant.length > 0 && dire.length > 0) {
        const r = radiant.shift();
        const d = dire.shift();
        if (r < d) {
            radiant.push(r + n);
        }
        else {
            dire.push(d + n);
        }
    }
    return radiant.length > 0 ? "Radiant" : "Dire";
}
document.getElementById("title").innerText =
    "649. Dota2 Senate (TS)";
let output = "";
// Example 1
const senate1 = "RD";
output += "<b>Input:</b> senate = \"" + senate1 + "\"<br>";
output += "<b>Output:</b> " + predictPartyVictory(senate1);
output += "<br><br>";
// Example 2
const senate2 = "RDD";
output += "<b>Input:</b> senate = \"" + senate2 + "\"<br>";
output += "<b>Output:</b> " + predictPartyVictory(senate2);
document.getElementById("output").innerHTML = output;
