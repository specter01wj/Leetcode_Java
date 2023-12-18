type Fn<T> = () => Promise<T>

function promiseAll<T>(functions: Fn<T>[]): Promise<T[]> {
	return new Promise((resolve, reject) => {
        const results: T[] = new Array(functions.length);
        let completed = 0;
        let hasRejected = false;

        if (functions.length === 0) {
            resolve(results);
        }

        functions.forEach((func, index) => {
            func()
                .then(result => {
                    if (hasRejected) return;

                    results[index] = result;
                    completed += 1;

                    if (completed === functions.length) {
                        resolve(results);
                    }
                })
                .catch(error => {
                    if (!hasRejected) {
                        hasRejected = true;
                        reject(error);
                    }
                });
        });
    });
};

let output = '';
const promise = promiseAll([() => new Promise(res => res(42))]);
promise.then((item) => {
  output = item;
  let webHeading1 = document.querySelector('#t1');
  webHeading1.textContent = 'Output: ' + (output);
}); // [42]


