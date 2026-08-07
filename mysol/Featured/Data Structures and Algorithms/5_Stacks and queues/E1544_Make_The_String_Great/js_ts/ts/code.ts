function makeGood(s: string): string {

  const stack: string[] = [];

  for (const c of s) {

    if (
      stack.length > 0 &&
      Math.abs(stack[stack.length - 1].charCodeAt(0) - c.charCodeAt(0)) === 32
    ) {

      stack.pop();

    } else {

      stack.push(c);
    }
  }

  return stack.join("");
}

(document.getElementById("title") as HTMLElement).innerText =
  "1544. Make The String Great (TS)";

let output: string = "";

// Example 1
const input1: string = "leEeetcode";

output += "<b>Example 1 Input:</b><br>";
output += input1;
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += makeGood(input1);
output += "<br><br>";

// Example 2
const input2: string = "abBAcC";

output += "<b>Example 2 Input:</b><br>";
output += input2;
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += makeGood(input2);
output += "<br><br>";

// Example 3
const input3: string = "s";

output += "<b>Example 3 Input:</b><br>";
output += input3;
output += "<br><br>";

output += "<b>Example 3 Output:</b><br>";
output += makeGood(input3);

(document.getElementById("output") as HTMLElement).innerHTML = output;