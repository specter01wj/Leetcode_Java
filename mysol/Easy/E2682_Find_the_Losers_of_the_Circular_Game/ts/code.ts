function circularGameLosers(n: number, k: number): number[] {
  const received = new Set<number>(); // Set to track friends who have received the ball
  let currentFriend = 1; // The game starts with the 1st friend
  let steps = 1; // Initial steps to pass the ball
  
  // Continue the game until a friend receives the ball twice
  while (!received.has(currentFriend)) {
      received.add(currentFriend); // Mark current friend as having received the ball
      currentFriend = (currentFriend + steps * k - 1) % n + 1; // Move to the next friend
      steps++; // Increase the steps (i * k for the next friend)
  }
  
  // Collect friends who did not receive the ball
  const losers: number[] = [];
  for (let i = 1; i <= n; i++) {
      if (!received.has(i)) {
          losers.push(i);
      }
  }
  
  return losers;
};

const input: number = 5, k: number = 2;
const results = circularGameLosers(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

