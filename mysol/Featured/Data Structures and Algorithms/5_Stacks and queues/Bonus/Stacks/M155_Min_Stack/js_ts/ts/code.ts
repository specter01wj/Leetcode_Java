function asteroidCollision(asteroids: number[]): number[] {
  const stack: number[] = [];

  for (const asteroid of asteroids) {
    let destroyed: boolean = false;

    // Collision only happens when stack top moves right
    // and current asteroid moves left
    while (
      stack.length > 0 &&
      stack[stack.length - 1] > 0 &&
      asteroid < 0
    ) {
      if (stack[stack.length - 1] < -asteroid) {
        stack.pop();
      } else if (stack[stack.length - 1] === -asteroid) {
        stack.pop();
        destroyed = true;
        break;
      } else {
        destroyed = true;
        break;
      }
    }

    if (!destroyed) {
      stack.push(asteroid);
    }
  }

  return stack;
}

(document.getElementById("title") as HTMLElement).innerText =
  "735. Asteroid Collision (TS)";

let output: string = "";

// Example 1
const input1: number[] = [5, 10, -5];

output += "<b>Example 1 Input:</b><br>";
output += "[" + input1.join(", ") + "]";
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += "[" + asteroidCollision(input1).join(", ") + "]";
output += "<br><br>";

// Example 2
const input2: number[] = [8, -8];

output += "<b>Example 2 Input:</b><br>";
output += "[" + input2.join(", ") + "]";
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += "[" + asteroidCollision(input2).join(", ") + "]";
output += "<br><br>";

// Example 3
const input3: number[] = [10, 2, -5];

output += "<b>Example 3 Input:</b><br>";
output += "[" + input3.join(", ") + "]";
output += "<br><br>";

output += "<b>Example 3 Output:</b><br>";
output += "[" + asteroidCollision(input3).join(", ") + "]";
output += "<br><br>";

// Example 4
const input4: number[] = [3, 5, -6, 2, -1, 4];

output += "<b>Example 4 Input:</b><br>";
output += "[" + input4.join(", ") + "]";
output += "<br><br>";

output += "<b>Example 4 Output:</b><br>";
output += "[" + asteroidCollision(input4).join(", ") + "]";

(document.getElementById("output") as HTMLElement).innerHTML = output;