function asteroidCollision(asteroids) {
    var stack = [];
    for (var _i = 0, asteroids_1 = asteroids; _i < asteroids_1.length; _i++) {
        var ast = asteroids_1[_i];
        var explode = false;
        while (stack.length > 0 && ast < 0 && stack[stack.length - 1] > 0) {
            if (stack[stack.length - 1] < -ast) {
                // The top asteroid in the stack is smaller; pop the stack
                stack.pop();
                continue;
            }
            else if (stack[stack.length - 1] === -ast) {
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
}
;
var input1 = [5, 10, -5];
var output1 = asteroidCollision(input1);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
