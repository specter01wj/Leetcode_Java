
class TwoSum {
  private numCounts: Map<number, number>;

  constructor() {
      this.numCounts = new Map<number, number>();
  }

  add(number: number): void {
      if (this.numCounts.has(number)) {
          this.numCounts.set(number, this.numCounts.get(number)! + 1);
      } else {
          this.numCounts.set(number, 1);
      }
  }

  find(value: number): boolean {
      for (let [key, count] of this.numCounts) {
          let complement = value - key;
          if (complement === key) {
              if (count > 1) {
                  return true;
              }
          } else {
              if (this.numCounts.has(complement)) {
                  return true;
              }
          }
      }
      return false;
  }

  toString(): string {
      const obj: { [key: number]: number } = {};
      for (let [key, value] of this.numCounts) {
          obj[key] = value;
      }
      return JSON.stringify(obj);
  }
}

const obj = new TwoSum();
obj.add(1);   // [] --> [1]
obj.add(3);   // [1] --> [1, 3]
obj.add(5);   // [1, 3] --> [1, 3, 5]

let webHeading = document.querySelector('#t1');
webHeading.textContent = "input: " + obj.toString() + 'Output: ' + '(4)' + obj.find(4) + '(7)' + obj.find(7);

