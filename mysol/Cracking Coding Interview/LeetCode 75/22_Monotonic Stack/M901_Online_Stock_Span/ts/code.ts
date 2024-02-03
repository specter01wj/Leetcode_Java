function dailyTemperatures(temperatures: number[]): number[] {
  let answer: number[] = new Array(temperatures.length).fill(0);
  let stack: number[] = []; // This stack will store indices

  for (let i = 0; i < temperatures.length; i++) {
      // Check if current temperature is higher than the last stacked temperature
      while (stack.length !== 0 && temperatures[i] > temperatures[stack[stack.length - 1]]) {
          let index: number = stack.pop()!;
          answer[index] = i - index;
      }
      stack.push(i);
  }

  return answer;
};

let input1 = [73,74,75,71,69,72,76,73];
let output1 = dailyTemperatures(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

