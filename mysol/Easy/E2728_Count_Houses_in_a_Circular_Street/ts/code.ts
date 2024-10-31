// Mock implementation of the Street class for testing purposes
class Street {
  private doors: boolean[];
  private position: number;

  constructor(doors: number[]) {
      this.doors = doors.map(door => door === 1); // Convert 0/1 array to boolean (false/true)
      this.position = 0;
  }

  public openDoor(): void {
      this.doors[this.position] = true;
  }

  public closeDoor(): void {
      this.doors[this.position] = false;
  }

  public isDoorOpen(): boolean {
      return this.doors[this.position];
  }

  public moveRight(): void {
      this.position = (this.position + 1) % this.doors.length;
  }

  public moveLeft(): void {
      this.position = (this.position - 1 + this.doors.length) % this.doors.length;
  }
}

function houseCount(street: Street | null, k: number): number {
  // Close all doors within the first k moves to prepare a consistent state
  for (let i = 0; i < k; i++) {
      if (street.isDoorOpen()) {
          street.closeDoor();
      }
      street.moveRight();
  }

  // Mark the starting point by opening the current door and moving to the next house
  street.openDoor();
  street.moveRight();

  let count = 0;

  // Count houses until we encounter the open door again
  while (!street.isDoorOpen()) {
      count += 1;
      street.moveRight();
  }

  // Include the starting house in the count
  return count + 1;
};

const input: number[] = [1,0,1,1,0];
const k: number = 5;
const street1 = new Street(input);
const results = houseCount(street1, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

