function numberOfAlternatingGroups(colors: number[]): number {
  let n = colors.length;
  let count = 0;

  for (let i = 0; i < n; i++) {
      let prev = colors[(i - 1 + n) % n];
      let curr = colors[i];
      let next = colors[(i + 1) % n];

      if (prev !== curr && curr !== next) {
          count++;
      }
  }

  return count;
};

const input: number[] = [0,1,0,0,1];
const results = numberOfAlternatingGroups(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

