
/*
*
*   Fold an array
*   https://www.codewars.com/kata/57ea70aa5500adfe8a000110
*
* */


function foldArray(array, runs) {

    let calculatedArray = array;

    for (let i = 0; i < runs; i++) {

        let x = parseInt(calculatedArray.length / 2);
        let result = []

        for (let j = 0; j < x; j++) {
            let firstPosition = calculatedArray[j]
            let lastPosition = calculatedArray[calculatedArray.length - 1 - j]

            result.push(firstPosition + lastPosition)
        }
        //add uneven number
        if ((calculatedArray.length / 2) % 1 !== 0) {
            result.push(calculatedArray[x])
        }

        calculatedArray = result;
    }

    return calculatedArray;
}


let input = [1, 2, 3, 4, 5]; // -> 15
foldArray(input, 3);



function foldArray2(a, n) {
    return n ? foldArray(a.map((x, i) => i + 1 <= a.length / 2 ? x + a[a.length - 1 - i] : x).slice(0, Math.ceil(a.length / 2)), n - 1) : a;
}
