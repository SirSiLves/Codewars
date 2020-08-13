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

        if ((calculatedArray.length / 2) % 1 !== 0) {
            result.push(calculatedArray[x])
        }

        calculatedArray = result;
    }

    return calculatedArray;
}


let input = [1, 2, 3, 4, 5];
foldArray(input, 3);
