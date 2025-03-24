function stableMountains(height: number[], threshold: number): number[] {
  const result: number[] = [];

  for (let i = 1; i < height.length; i++) {
      if (height[i - 1] > threshold) {
          result.push(i);
      }
  }

  return result;
};

const input: number[] = [1,2,3,4,5];
const threshold: number = 2;
const results = stableMountains(input, threshold);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

