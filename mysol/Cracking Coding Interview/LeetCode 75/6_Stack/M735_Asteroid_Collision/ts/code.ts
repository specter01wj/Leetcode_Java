function asteroidCollision(asteroids: number[]): number[] {
  let stack: number[] = [];

  for (let ast of asteroids) {
      let explode = false;

      while (stack.length > 0 && ast < 0 && stack[stack.length - 1] > 0) {
          if (stack[stack.length - 1] < -ast) {
              // The top asteroid in the stack is smaller; pop the stack
              stack.pop();
              continue;
          } else if (stack[stack.length - 1] === -ast) {
              // Both asteroids are of the same size; both explode
              stack.pop();
              explode = true;
              break;
          }
          // The asteroid in the stack is larger; current asteroid explodes
          explode = true;
          break;
      }

      if (!explode) {
          // No explosion occurred, so push the current asteroid onto the stack
          stack.push(ast);
      }
  }

  return stack;
};

let input1 = [5,10,-5];
let output1 = asteroidCollision(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

