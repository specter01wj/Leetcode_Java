type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Fn = (...args: JSONValue[]) => void

function cancellable(fn: Fn, args: JSONValue[], t: number): Function {
	let timeoutId: NodeJS.Timeout | null = null;

    const cancelFn = (): void => {
        clearTimeout(timeoutId);
    };

    timeoutId = setTimeout(() => {
        fn(...args);
    }, t);

    return cancelFn;
};


const result = [];
const fn = (x) => x * 5;
const args = [2], t = 20, cancelT = 50;
const start = performance.now();
const log = (...argsArr) => {
  const diff = Math.floor(performance.now() - start);
  result.push({"time": diff, "returned": fn(...argsArr)});
};

const cancel = cancellable(log, args, t);

const maxT = Math.max(t, cancelT);
          
setTimeout(() => {
    cancel()
}, cancelT);

setTimeout(() => {
    console.log(result); // [{"time":20,"returned":10}]
    let output1 = result;
    let webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + 'Time - ' + (output1[0].time) + '; Returned - ' + (output1[0].returned);
}, maxT + 15);




