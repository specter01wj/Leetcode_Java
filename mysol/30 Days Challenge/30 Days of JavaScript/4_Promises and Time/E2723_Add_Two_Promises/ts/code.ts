type P = Promise<number>

async function addTwoPromises(promise1: P, promise2: P): P {
	return Promise.all([promise1, promise2])
        .then((values: number[]) => {
            const sum = values.reduce((total, value) => total + value, 0);
            return sum;
        });
};

let output1 = '';
addTwoPromises(Promise.resolve(2), Promise.resolve(2))
  .then( val => {
    output1 = val;
    let webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + output1.toString();
  });



