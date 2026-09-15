function sumSubarrayMins(arr: number[]): number {
    const mod: number = 1000000007;
    const n: number = arr.length;

    const left: number[] = new Array(n);
    const right: number[] = new Array(n);

    const stack: number[] = [];

    // Distance to previous smaller element
    for (let i = 0; i < n; i++) {
        while (
            stack.length > 0 &&
            arr[stack[stack.length - 1]] > arr[i]
        ) {
            stack.pop();
        }

        left[i] =
            stack.length === 0 ? i + 1 : i - stack[stack.length - 1];

        stack.push(i);
    }

    stack.length = 0;

    // Distance to next smaller or equal element
    for (let i = n - 1; i >= 0; i--) {
        while (
            stack.length > 0 &&
            arr[stack[stack.length - 1]] >= arr[i]
        ) {
            stack.pop();
        }

        right[i] =
            stack.length === 0 ? n - i : stack[stack.length - 1] - i;

        stack.push(i);
    }

    let answer: number = 0;

    for (let i = 0; i < n; i++) {
        answer = (answer + arr[i] * left[i] * right[i]) % mod;
    }

    return answer;
}

(document.getElementById("title") as HTMLElement).innerText =
    "907. Sum of Subarray Minimums (TS)";

let output: string = "";

// Example 1
const arr1: number[] = [3, 1, 2, 4];

output += "<b>Input:</b> arr = [" + arr1 + "]<br>";
output += "<b>Output:</b> " + sumSubarrayMins(arr1);
output += "<br><br>";

// Example 2
const arr2: number[] = [11, 81, 94, 43, 3];

output += "<b>Input:</b> arr = [" + arr2 + "]<br>";
output += "<b>Output:</b> " + sumSubarrayMins(arr2);

(document.getElementById("output") as HTMLElement).innerHTML = output;