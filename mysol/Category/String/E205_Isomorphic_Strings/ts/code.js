function isIsomorphic(s, t) {
    if (s.length !== t.length)
        return false;
    const mapST = new Map();
    const mapTS = new Map();
    for (let i = 0; i < s.length; i++) {
        const sc = s[i];
        const tc = t[i];
        if (mapST.has(sc)) {
            if (mapST.get(sc) !== tc)
                return false;
        }
        else {
            mapST.set(sc, tc);
        }
        if (mapTS.has(tc)) {
            if (mapTS.get(tc) !== sc)
                return false;
        }
        else {
            mapTS.set(tc, sc);
        }
    }
    return true;
}
;
const input = "egg", t = "add";
const results = isIsomorphic(input, t);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
