class SmallestInfiniteSet {
  private available: Set<number>;
  private nextSmallest: number;

  constructor() {
      this.available = new Set<number>();
      this.nextSmallest = 1;
  }

  popSmallest(): number {
      // Check if there's a number in the available set smaller than nextSmallest
      if (this.available.size > 0 && Math.min(...this.available) < this.nextSmallest) {
          const smallestAvailable = Math.min(...this.available);
          this.available.delete(smallestAvailable);
          return smallestAvailable;
      }
      // Otherwise, return the nextSmallest number and increment it
      return this.nextSmallest++;
  }

  addBack(num: number): void {
      // Add the number back only if it's smaller than the nextSmallest
      if (num < this.nextSmallest) {
          this.available.add(num);
      }
  }
}

let actions = ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"];
let parameters = [[], [2], [], [], [], [1], [], [], []];
let results = [];

let set = new SmallestInfiniteSet();

actions.forEach((action, index) => {
    if (action === "addBack") {
        set.addBack(parameters[index][0]);
        results.push(null);
    } else if (action === "popSmallest") {
        results.push(set.popSmallest());
    } else {
        results.push(null);
    }
});

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(results);

