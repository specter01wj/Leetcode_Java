type TaxBracket = [number, number];

function calculateTax(brackets: TaxBracket[], income: number): number {
  let tax = 0;
  let prev = 0;
  for (let bracket of brackets) {
    let upper = bracket[0], percent = bracket[1];
    if (income >= upper) {
      tax += (upper - prev) * percent / 100;
      prev = upper;
    } else {
      tax += (income - prev) * percent / 100;
      return tax;
    }
  }
  
  return tax;
}

let input: TaxBracket[] = [[3,50],[7,10],[12,25]];
let output = calculateTax(input, 10);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


