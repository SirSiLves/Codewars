/*
*
*   A Chain adding function
*   https://www.codewars.com/kata/539a0e4d85e3425cb0000a88/train/javascript
*
* */

function add(n) {

    let nF = function (x) {
        return add(x + n);
    };

    nF.valueOf = function () {
        return n;
    };

    return nF;
}

console.log("Add all together: " + add(5)(10)(15))


let addArrow = function (n) {
    const f = x => add(n + x)
    f.valueOf = () => n
    return f;
}
console.log("Add all together: " + addArrow(5)(10)(15))

