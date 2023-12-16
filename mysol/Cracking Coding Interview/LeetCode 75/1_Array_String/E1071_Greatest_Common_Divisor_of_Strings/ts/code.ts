function gcdOfStrings(str1: string, str2: string): string {
  if ((str1 + str2) !== (str2 + str1)) {
      return "";
  }

  let gcdVal = gcd(str1.length, str2.length);
  return str2.substring(0, gcdVal);
}

function gcd(p: number, q: number): number {
  if (q === 0) {
      return p;
  } else {
      return gcd(q, p % q);
  }
}

let str1 = "ABABAB", str2 = "ABAB";
let output1 = gcdOfStrings(str1, str2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

