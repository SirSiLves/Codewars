function findOdd(A) {

    A = A.sort();

    let count = 1;
    let countArray = [];
    let reset = false;

    for (let i = 0; i < A.length; i++) {

        if (A.length > 1 && A[i] === A[i + 1]) {
            count++;
        } else {

            if (countArray.length === 0) {
                countArray.push([[A[i], count]]);
            } else {

                for (let j = 0; j < countArray.length; j++) {

                    if (countArray[j][0][1] === count) {
                        countArray[j].push([A[i], count]);
                        reset = true;
                        break;
                    }

                }

                if (!reset) {
                    countArray.push([[A[i], count]])
                }
            }

            count = 1;
            reset = false;
        }
    }

    countArray.sort(function(a, b){
        if(b.length === a.length){
            return  a[0][1] - b[0][1];
        }
        else return a.length - b.length;
    });

    console.log(countArray[0][0][0])
    return countArray[0][0][0];

}


findOdd([1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5]) // -> -1
findOdd([20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5]) // -> 5
findOdd([20, 1, -1, 4, -1, 2, 2, 7, -2, 8, 1, 7, 3, -2, 3, 20, 5, 7, 3, 5, 1, 7, 2, 4, 20, 4, 5, -1, -2]) // -> 8
findOdd([10]) // -> 10
findOdd([ 5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10 ]) // -> 1
