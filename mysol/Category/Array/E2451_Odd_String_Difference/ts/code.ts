
function haveConflict(event1: string[], event2: string[]): boolean {
  // Helper function to convert "HH:MM" to minutes since 00:00
  const timeToMinutes = (time: string): number => {
      const [hours, minutes] = time.split(':').map(Number);
      return hours * 60 + minutes;
  };

  // Convert event start and end times to minutes since 00:00
  const start1 = timeToMinutes(event1[0]);
  const end1 = timeToMinutes(event1[1]);
  const start2 = timeToMinutes(event2[0]);
  const end2 = timeToMinutes(event2[1]);

  // Check if there is an overlap between event1 and event2
  return !(end1 < start2 || end2 < start1);
};

const event1: string[] = ["01:15", "02:00"];
const event2: string[] = ["02:00", "03:00"];
const results = haveConflict(event1, event2);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input1: ' + event1 + '; Input2: ' + event2 + '<br>Result = ' + results;

