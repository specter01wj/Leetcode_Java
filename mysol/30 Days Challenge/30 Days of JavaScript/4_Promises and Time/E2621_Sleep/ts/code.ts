async function sleep(millis: number): Promise<void> {
  await new Promise<void>(resolve => setTimeout(resolve, millis));
}

let input = Date.now();
let output1 = '';
sleep(100)
  .then( () => {
    output1 = (Date.now() - input);
    let webHeading1 = document.querySelector('#t1');
    webHeading1.textContent = 'Output: ' + output1.toString();
  });



