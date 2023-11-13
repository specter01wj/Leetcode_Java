
function bestHand(ranks: number[], suits: string[]): string {
  let cnt = new Array(14).fill(0);
  let max = 0;
  
  for (let rank of ranks) {
    cnt[rank]++;
    if (cnt[rank] > max) {
      max = cnt[rank];
    }
  }
  
  if (suits[0] === suits[1] && suits[1] === suits[2] && suits[2] === suits[3] && suits[3] === suits[4]) {
    return "Flush";
  }
  
  if (max >= 3) {
    return "Three of a Kind";
  } else if (max == 2) {
    return "Pair";
  } else {
    return "High Card";
  }
}

let input: number[] = [13,2,3,1,9];
let suits: string[] = ["a","a","a","a","a"];
let output = bestHand(input, suits);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


