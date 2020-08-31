
/*
*
*   Jewel Thief
*   https://www.codewars.com/kata/5b40a38f6be5d82775000003
*
* */

var crack = function (safe) {

    let code = "";
    let tries = 3;

    while (tries > 0) {
        for (let i = 0; i < 200; i++) {
            if (i < 100) {
                let n = code + "L" + (i < 10 ? "0" : "") + i

                if ((tries === 3 && safe.unlock(n) === 'click')
                    || (tries === 2 && safe.unlock(n) === 'click-click')
                    || (tries === 1 && safe.unlock(n) === 'click-click-click')) {
                    code += "L" + (i < 10 ? "0" : "") + i + (tries > 1 ? "-" : "");
                    break;
                }

            } else {
                let n = code + "R" + (i % 100 < 10 ? "0" : "") + i % 100;

                if ((tries === 3 && safe.unlock(n) === 'click')
                    || (tries === 2 && safe.unlock(n) === 'click-click')
                    || (tries === 1 && safe.unlock(n) === 'click-click-click')) {
                    code += "R" + (i < 110 ? "0" : "") + i % 100 + (tries > 1 ? "-" : "");
                    break;
                }
            }
        }
        tries--;
    }
    return safe.open();
}
