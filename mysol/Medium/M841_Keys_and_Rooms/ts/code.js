function canVisitAllRooms(rooms) {
    var visited = new Set(); // Set to keep track of visited rooms
    function dfs(room) {
        visited.add(room); // Mark the current room as visited
        // Go through all the keys in the current room
        rooms[room].forEach(function (key) {
            if (!visited.has(key)) {
                dfs(key); // Visit the room if it has not been visited
            }
        });
    }
    dfs(0); // Start DFS from room 0
    // Check if the number of visited rooms is equal to the total number of rooms
    return visited.size === rooms.length;
}
;
var input1 = [[1], [2], [3], []];
var output1 = canVisitAllRooms(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
