function minFlips(a: number, b: number, c: number): number {
  let flips = 0;

  while (a > 0 || b > 0 || c > 0) {
      let lastBitA = a & 1;
      let lastBitB = b & 1;
      let lastBitC = c & 1;

      // Check if the current bits of a and b do not match the bit in c
      if ((lastBitA | lastBitB) !== lastBitC) {
          flips += (lastBitC === 0) ? (lastBitA + lastBitB) : 1;
      }

      // Move to the next set of bits
      a >>= 1;
      b >>= 1;
      c >>= 1;
  }

  return flips;
};

let a = 2, b = 6, c = 5;
let output1 = minFlips(a, b, c);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

