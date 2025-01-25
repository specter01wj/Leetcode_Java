function minimumBoxes(apple: number[], capacity: number[]): number {
  // Calculate the total number of apples
  const totalApples = apple.reduce((sum, count) => sum + count, 0);

  // Sort the capacity array in descending order
  capacity.sort((a, b) => b - a);

  let boxesUsed = 0;
  let currentCapacity = 0;

  // Select boxes until the total capacity meets or exceeds the total apples
  for (const box of capacity) {
      currentCapacity += box;
      boxesUsed++;
      if (currentCapacity >= totalApples) {
          break;
      }
  }

  return boxesUsed;
};

const input: number[] = [1,3,2], capacity: number[] = [4,3,1,5,2];
const results = minimumBoxes(input, capacity);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

