function interfaceGuide(): void {
    // Declaration with explicit type: keys and values are numbers
    const hashMap: Map<number, number> = new Map([
        [1, 2],
        [5, 3],
        [7, 2]
    ]);

    // Check if key exists
    console.log("has 1?", hashMap.has(1)); // true
    console.log("has 9?", hashMap.has(9)); // false

    // Access value
    console.log("get 5:", hashMap.get(5)); // 3

    // Update existing key
    hashMap.set(5, 6);

    // Insert new key
    hashMap.set(9, 15);

    // Delete a key
    hashMap.delete(9);

    // Get size
    console.log("size:", hashMap.size); // 3

    // Iterate over entries
    console.log("Entries:");
    for (const [key, value] of hashMap) {
        console.log(`${key} => ${value}`);
    }
};

function interactive(): void {
    const myHashMap: Map<number, number> = new Map();

    myHashMap.set(4, 83);
    console.log(myHashMap.get(4)); // 83

    console.log(myHashMap.has(4));    // true
    console.log(myHashMap.has(854));  // false

    myHashMap.set(8, 327);
    myHashMap.set(45, 82523);

    console.log("Map contents:");
    for (const [key, val] of myHashMap) {
        console.log(`${key}: ${val}`);
    }
}

const input: string = "Interface guide";
console.log("====== interfaceGuide() ======");
interfaceGuide();
console.log("====== interactive() ======");
interactive();
const results = "results in console.log";

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

