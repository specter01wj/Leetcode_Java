function finalPositionOfSnake(n: number, commands: string[]): number {
  let row = 0, col = 0; // The snake starts at position (0,0)

  for (let command of commands) {
      switch (command) {
          case "UP":
              row -= 1;
              break;
          case "DOWN":
              row += 1;
              break;
          case "LEFT":
              col -= 1;
              break;
          case "RIGHT":
              col += 1;
              break;
      }
  }

  // Convert (row, col) position to 1D index
  return (row * n) + col;
};

const commands: string[] = ["RIGHT","DOWN"];
const n: number = 2;
const results = finalPositionOfSnake(n, commands);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(commands, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

