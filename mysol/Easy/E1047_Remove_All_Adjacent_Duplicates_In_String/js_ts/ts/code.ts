function removeDuplicates(s: string): string {

    const stack: string[] = [];

    for (const c of s) {

        if (stack.length > 0 && stack[stack.length - 1] === c) {

            stack.pop();

        } else {

            stack.push(c);

        }
    }

    return stack.join("");
}

(document.getElementById("title") as HTMLElement).innerText =
    "1047. Remove All Adjacent Duplicates In String (TS)";

let output: string = "";

// Example 1
const input1: string = "abbaca";

output += "<b>Example 1 Input:</b><br>";
output += input1;
output += "<br><br>";

output += "<b>Example 1 Output:</b><br>";
output += removeDuplicates(input1);
output += "<br><br>";

// Example 2
const input2: string = "azxxzy";

output += "<b>Example 2 Input:</b><br>";
output += input2;
output += "<br><br>";

output += "<b>Example 2 Output:</b><br>";
output += removeDuplicates(input2);

(document.getElementById("output") as HTMLElement).innerHTML = output;