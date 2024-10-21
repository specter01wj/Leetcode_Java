function isWinner(player1: number[], player2: number[]): number {
  const score1 = calculateScore(player1);
  const score2 = calculateScore(player2);
  
  if (score1 > score2) {
      return 1;
  } else if (score2 > score1) {
      return 2;
  } else {
      return 0;
  }
};

function calculateScore(player: number[]): number {
  let totalScore = 0;

  for (let i = 0; i < player.length; i++) {
      let currentTurnScore = player[i];
      
      // Check if the previous or two-turns-ago hit exactly 10 pins
      if ((i > 0 && player[i - 1] === 10) || (i > 1 && player[i - 2] === 10)) {
          currentTurnScore *= 2;
      }
      
      totalScore += currentTurnScore;
  }
  
  return totalScore;
}

const player1: number[] = [5,10,3,2], player2: number[] = [6,5,7,3];
const results = isWinner(player1, player2);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input1: ' + JSON.stringify(player1, null, 2) + 
    '; Input2: ' + JSON.stringify(player2, null, 2) + 
    '<br>Result = ' + JSON.stringify(results, null, 2);

