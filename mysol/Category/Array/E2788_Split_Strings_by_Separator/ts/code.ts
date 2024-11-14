function splitWordsBySeparator(words: string[], separator: string): string[] {
  const result: string[] = [];
  const separatorStr = separator.replace(/[-\/\\^$*+?.()|[\]{}]/g, '\\$&'); // Escape special characters in the separator

  for (const word of words) {
      // Split the word by the separator
      const parts = word.split(new RegExp(separatorStr));
      
      // Add non-empty strings to the result
      for (const part of parts) {
          if (part) { // Only add non-empty strings
              result.push(part);
          }
      }
  }

  return result;
};

const input: string[] = ["one.two.three","four.five","six"];
const separator: string = ".";
const results = splitWordsBySeparator(input, separator);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

