type Fn = (...params: any[]) => Promise<any>;

function timeLimit(fn: Fn, t: number): Fn {
    
	return async function(...args) {
    let timeoutPromise = new Promise<any>((_, reject) => {
      setTimeout(() => reject("Time Limit Exceeded"), t);
    });

    let fnPromise = fn(...args);

    return Promise.race([fnPromise, timeoutPromise]);
  }
};

const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);

limited(150).catch((result) => {
  let output1 = result;
  let webHeading1 = document.querySelector('#t1');
  webHeading1.textContent = 'Output: ' + (output1);
});


