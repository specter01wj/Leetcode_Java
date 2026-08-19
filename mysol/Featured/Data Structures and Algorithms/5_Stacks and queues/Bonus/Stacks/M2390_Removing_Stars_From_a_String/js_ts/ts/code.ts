function removeStars(s: string): string {

  const stack: string[] = [];

  for (const c of s) {

    if (c === "*") {
      stack.pop();
    } else {
      stack.push(c);
    }
  }

  return stack.join("");
}

(document.getElementById("title") as HTMLElement).innerText =
  "2390. Removing Stars From a String (TS)";

let output: string = "";

// Example 1
const input1: string = "leet**cod*e";

output += "<b>Example 1 Input:</b><br>";
output += input1;
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += removeStars(input1);
output += "<br><br>";

// Example 2
const input2: string = "erase*****";

output += "<b>Example 2 Input:</b><br>";
output += input2;
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += removeStars(input2);

(document.getElementById("output") as HTMLElement).innerHTML = output;