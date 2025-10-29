function destCity(paths: string[][]): string {
    const startingCities = new Set<string>();

    for (const [from, _] of paths) {
        startingCities.add(from);
    }

    for (const [_, to] of paths) {
        if (!startingCities.has(to)) {
            return to;
        }
    }

    return "";
};

const input: string[][] = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]];
const results = destCity(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

