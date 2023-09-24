// Number.EPSILON  用于浮点数运算
console.log(Number.EPSILON);
let equal = (a,b)=>{
    return Math.abs(a - b) < Number.EPSILON;
}
console.log(0.1+0.2===0.3);
console.log(equal(0.1 + 0.2, 0.3));


//二进制和八进制

let b = 0b1010 //二进制
let o = 0o777; //八进制
let x = 0xff; //十六进制


console.log(b)
console.log(o);
console.log(x);

//
console.log(Number.isFinite(199));
console.log(Number.isFinite(Infinity));

//
Number.isNaN(123);
console.log(Number.isNaN(NaN));

//
console.log(Number.parseInt('123'));
console.log(Number.parseFloat('123.21'));

//
console.log(Math.trunc(3.5));

//
console.log(Math.sign(2323));
console.log(Math.sign(-2323));