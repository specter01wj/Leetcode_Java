function predictPartyVictory(senate: string): string {
    const radiant: number[] = [];
    const dire: number[] = [];
    const n: number = senate.length;

    for (let i = 0; i < n; i++) {
        if (senate[i] === "R") {
            radiant.push(i);
        } else {
            dire.push(i);
        }
    }

    while (radiant.length > 0 && dire.length > 0) {
        const r: number = radiant.shift()!;
        const d: number = dire.shift()!;

        if (r < d) {
            radiant.push(r + n);
        } else {
            dire.push(d + n);
        }
    }

    return radiant.length > 0 ? "Radiant" : "Dire";
}

(document.getElementById("title") as HTMLElement).innerText =
    "649. Dota2 Senate (TS)";

let output: string = "";

// Example 1
const senate1: string = "RD";

output += "<b>Input:</b> senate = \"" + senate1 + "\"<br>";
output += "<b>Output:</b> " + predictPartyVictory(senate1);
output += "<br><br>";

// Example 2
const senate2: string = "RDD";

output += "<b>Input:</b> senate = \"" + senate2 + "\"<br>";
output += "<b>Output:</b> " + predictPartyVictory(senate2);

(document.getElementById("output") as HTMLElement).innerHTML = output;