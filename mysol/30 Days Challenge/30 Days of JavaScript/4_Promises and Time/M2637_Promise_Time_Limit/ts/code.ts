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


const result = [];
const fn = (x) => x * 2;
const args = [4], t = 35, cancelT = 190;
const start = performance.now();

const log = (...argsArr) => {
  const diff = Math.floor(performance.now() - start);
  result.push({"time": diff, "returned": fn(...argsArr)});
};

const cancel = cancellable(log, args, t);

const maxT = Math.max(t, cancelT);
          
setTimeout(() => {
    cancel();
}, cancelT);

setTimeout(() => {
    console.log(result);
    let output1 = result;
    let webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + 'Time - ' + (output1[0].time) + '; Returned - ' + (output1[0].returned);
}, maxT + 15);




