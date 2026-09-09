function finalPrices(prices: number[]): number[] {
    const answer: number[] = [...prices];
    const stack: number[] = [];

    for (let i = 0; i < prices.length; i++) {
        while (
            stack.length > 0 &&
            prices[stack[stack.length - 1]] >= prices[i]
        ) {
            const index: number = stack.pop()!;
            answer[index] = prices[index] - prices[i];
        }

        stack.push(i);
    }

    return answer;
}

(document.getElementById("title") as HTMLElement).innerText =
    "1475. Final Prices With a Special Discount in a Shop (TS)";

let output: string = "";

// Example 1
const prices1: number[] = [8, 4, 6, 2, 3];

output += "<b>Input:</b> prices = [" + prices1 + "]<br>";
output += "<b>Output:</b> [" + finalPrices(prices1) + "]";
output += "<br><br>";

// Example 2
const prices2: number[] = [1, 2, 3, 4, 5];

output += "<b>Input:</b> prices = [" + prices2 + "]<br>";
output += "<b>Output:</b> [" + finalPrices(prices2) + "]";
output += "<br><br>";

// Example 3
const prices3: number[] = [10, 1, 1, 6];

output += "<b>Input:</b> prices = [" + prices3 + "]<br>";
output += "<b>Output:</b> [" + finalPrices(prices3) + "]";

(document.getElementById("output") as HTMLElement).innerHTML = output;