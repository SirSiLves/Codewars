/*
*
*
*   int32 to IPv4
*   https://www.codewars.com/kata/52e88b39ffb6ac53a400022e
*
* */


function int32ToIp(int32) {

    let binary = (int32 >>> 0).toString(2);
    let ipValue = "";

    let bitBlock = 0;
    for (let i = 32; i > 0; i -= 8) {

        if (i < 32) ipValue += "."

        if (binary.length < i && i > 8) ipValue += 0;
        else {
            if (bitBlock > binary.length) bitBlock = 0;
            ipValue += parseInt(binary.substr(bitBlock, 8), 2);

        }
        bitBlock += 8;
    }

    // console.log(ipValue)
    return ipValue;
}


function int32ToIp2(int32){
    return (int32>>>24) + '.' + (int32<<8>>>24) + '.' + (int32<<16>>>24) + '.' + (int32<<24>>>24)
}

int32ToIp(2149583361) // => 128.32.10.1
int32ToIp(32) // => 0.0.0.32/
int32ToIp(0) // => 0.0.0.0


