function canVisitAllRooms(rooms: number[][]): boolean {
  let visited: Set<number> = new Set(); // Set to keep track of visited rooms

  function dfs(room: number) {
      visited.add(room); // Mark the current room as visited

      // Go through all the keys in the current room
      rooms[room].forEach(key => {
          if (!visited.has(key)) {
              dfs(key); // Visit the room if it has not been visited
          }
      });
  }

  dfs(0); // Start DFS from room 0

  // Check if the number of visited rooms is equal to the total number of rooms
  return visited.size === rooms.length;
};

let input1 = [[1],[2],[3],[]];
let output1 = canVisitAllRooms(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

