type F = (...args: number[]) => void

function debounce(fn: F, t: number): F {
    let timeoutID: number | undefined;

    return function(...args: number[]) {
        
        clearTimeout(timeoutID);

        timeoutID = setTimeout(() => {
            fn(...args);
        }, t) as unknown as number;
    };
};

let output = '';
const log = debounce((item) => {
  output = item;
  let webHeading1 = document.querySelector('#t1');
  webHeading1.textContent = 'Output: ' + (output);
}, 100);
log('Hello1'); // cancelled
log('Hello2'); // cancelled
output = log('Hello3'); // Logged at t=100ms


