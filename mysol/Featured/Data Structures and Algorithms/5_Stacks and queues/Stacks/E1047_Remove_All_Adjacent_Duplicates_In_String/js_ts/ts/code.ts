function isValid(s: string): boolean {

  const matching = new Map<string, string>();
  matching.set("(", ")");
  matching.set("[", "]");
  matching.set("{", "}");

  const stack: string[] = [];

  for (const c of s) {

    // Opening bracket
    if (matching.has(c)) {
      stack.push(c);
    } else {

      // Closing bracket with no matching opening bracket
      if (stack.length === 0) {
        return false;
      }

      const previousOpening: string = stack.pop()!;

      // Brackets do not match
      if (matching.get(previousOpening) !== c) {
        return false;
      }
    }
  }

  // Valid only if no unmatched opening brackets remain
  return stack.length === 0;
}

(document.getElementById("title") as HTMLElement).innerText =
  "20. Valid Parentheses (TS)";

let output: string = "";

// Example 1
const input1: string = "()";

output += "<b>Example 1 Input:</b><br>";
output += input1;
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += isValid(input1);
output += "<br><br>";

// Example 2
const input2: string = "()[]{}";

output += "<b>Example 2 Input:</b><br>";
output += input2;
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += isValid(input2);
output += "<br><br>";

// Example 3
const input3: string = "(]";

output += "<b>Example 3 Input:</b><br>";
output += input3;
output += "<br><br>";

output += "<b>Example 3 Output:</b><br>";
output += isValid(input3);
output += "<br><br>";

// Example 4
const input4: string = "([])";

output += "<b>Example 4 Input:</b><br>";
output += input4;
output += "<br><br>";

output += "<b>Example 4 Output:</b><br>";
output += isValid(input4);
output += "<br><br>";

// Example 5
const input5: string = "([)]";

output += "<b>Example 5 Input:</b><br>";
output += input5;
output += "<br><br>";

output += "<b>Example 5 Output:</b><br>";
output += isValid(input5);

(document.getElementById("output") as HTMLElement).innerHTML = output;