type F = (...args: number[]) => void

function throttle(fn: F, t: number): F {
    let lastCall: number = 0;
    let timeoutId: any = null;
    let lastArgs: number[] | null = null;

	return function (...args) {
		const now = Date.now();

        // If this is the first call or the last call was t or more milliseconds ago
        if (lastCall === 0 || (now - lastCall >= t)) {
            // Call the function immediately and update lastCall
            lastCall = now;
            fn.apply(this, args);
        } else {
            // Save the latest arguments
            lastArgs = args;

            // Clear the existing timeout, if any
            if (timeoutId) {
                clearTimeout(timeoutId);
            }

            // Set a new timeout to call the function after the remaining time in the t milliseconds period
            timeoutId = setTimeout(() => {
                // Update lastCall to the current time
                lastCall = Date.now();
                fn.apply(this, lastArgs);
                lastArgs = null;
                timeoutId = null;
            }, lastCall + t - now);
        }
	}
};

let input = '';
const throttled = throttle((item) => {
  let output1 = item;
  let webHeading1 = document.querySelector('#t1');
  webHeading1.textContent = 'Output: ' + output1.toString();
}, 1000);
throttled("log"); // logged immediately.
throttled("log1000"); // logged at t=100ms.



