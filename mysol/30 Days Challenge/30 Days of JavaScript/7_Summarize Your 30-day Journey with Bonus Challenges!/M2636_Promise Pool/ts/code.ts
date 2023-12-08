type F = () => Promise<any>;

function promisePool(functions: F[], n: number): Promise<any> {
	return new Promise<any>(async (resolve) => {
        const results: any[] = [];
        const inProgress: Promise<any>[] = [];
        let i = 0;

        while (i < functions.length || inProgress.length > 0) {
            while (inProgress.length < n && i < functions.length) {
                const promise = functions[i]();
                const index = i;
                const resultPromise = promise.then((result) => {
                    results[index] = result;
                    inProgress.splice(inProgress.indexOf(resultPromise), 1);
                });
                inProgress.push(resultPromise);
                i++;
            }

            if (inProgress.length > 0) {
                await Promise.race(inProgress);
            }
        }

        resolve(results);
    });
};

let input = '';
const sleep = (t) => new Promise(res => setTimeout(res, t));
promisePool([() => sleep(500), () => sleep(400)], 1)
  .then((item) => {
    let output1 = item.length;
    let webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + output1.toString();
  });


