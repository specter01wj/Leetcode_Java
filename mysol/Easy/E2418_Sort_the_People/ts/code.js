function sortPeople(names, heights) {
    // Create an array of indices
    const indices = names.map((_, index) => index);
    // Sort the indices array based on the corresponding heights in descending order
    indices.sort((a, b) => heights[b] - heights[a]);
    // Create a new array for the sorted names
    const sortedNames = indices.map(index => names[index]);
    return sortedNames;
}
;
const input = ["Mary", "John", "Emma"];
const heights = [180, 165, 170];
const results = sortPeople(input, heights);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
