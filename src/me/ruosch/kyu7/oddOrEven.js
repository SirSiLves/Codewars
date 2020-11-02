/*
*
*
*   Odd or Even?
*   https://www.codewars.com/kata/5949481f86420f59480000e7
*
* */

function oddOrEven(array) {
    //enter code here
    let sum = 0;
    array.forEach(a => {
        sum += a;
    });

    if(sum % 2 === 0) return "even";
    else return "odd";
}


console.log(oddOrEven([0, 1, 5]))
console.log(oddOrEven([-1023, -1, 3]))
console.log(oddOrEven([]))


function oddOrEven2(arr) {
    return arr.reduce((a,b)=>a+b,0) % 2 ? 'odd' : 'even';

}

