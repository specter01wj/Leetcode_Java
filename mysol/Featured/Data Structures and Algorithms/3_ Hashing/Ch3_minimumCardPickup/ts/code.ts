function minimumCardPickup(cards: number[]): number {
    const lastSeen = new Map<number, number>();
    let minLength = Infinity;

    for (let i = 0; i < cards.length; i++) {
        const card = cards[i];
        if (lastSeen.has(card)) {
            minLength = Math.min(minLength, i - lastSeen.get(card)! + 1);
        }
        lastSeen.set(card, i);
    }

    return minLength === Infinity ? -1 : minLength;
};

const input: number[] = [3,4,2,3,4,7];
const results = minimumCardPickup(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

