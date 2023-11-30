type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Fn = (...args: JSONValue[]) => void;

function cancellable(fn: Fn, args: JSONValue[], t: number): Function {
	fn.apply(null, args);

  const intervalId = setInterval(() => {
    fn.apply(null, args);
  }, t);

  return function cancelFn() {
    clearInterval(intervalId);
  };
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




