function dailyTemperatures(temperatures: number[]): number[] {

  const stack: number[] = [];
  const answer: number[] = new Array(temperatures.length).fill(0);

  for (let i = 0; i < temperatures.length; i++) {

    while (
      stack.length > 0 &&
      temperatures[stack[stack.length - 1]] < temperatures[i]
    ) {
      const j: number = stack.pop()!;
      answer[j] = i - j;
    }

    stack.push(i);
  }

  return answer;
}

(document.getElementById("title") as HTMLElement).innerText =
  "739. Daily Temperatures (TS)";

let output: string = "";

// Example 1
const input1: number[] = [73, 74, 75, 71, 69, 72, 76, 73];

output += "<b>Example 1 Input:</b><br>";
output += "[" + input1.join(", ") + "]";
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += "[" + dailyTemperatures(input1).join(", ") + "]";
output += "<br><br>";

// Example 2
const input2: number[] = [30, 40, 50, 60];

output += "<b>Example 2 Input:</b><br>";
output += "[" + input2.join(", ") + "]";
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += "[" + dailyTemperatures(input2).join(", ") + "]";
output += "<br><br>";

// Example 3
const input3: number[] = [30, 60, 90];

output += "<b>Example 3 Input:</b><br>";
output += "[" + input3.join(", ") + "]";
output += "<br><br>";

output += "<b>Example 3 Output:</b><br>";
output += "[" + dailyTemperatures(input3).join(", ") + "]";

(document.getElementById("output") as HTMLElement).innerHTML = output;