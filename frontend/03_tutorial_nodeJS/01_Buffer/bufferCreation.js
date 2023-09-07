//1.alloc
let buf = Buffer.alloc(10);
console.log(buf);

//2.allocUnsafe
let buf2 = Buffer.allocUnsafe(10);
console.log(buf2);

//3.from
let buf3 = Buffer.from('Hello'); //Unicode
let buf4 = Buffer.from([1,2,3,4,5]);
console.log(buf3);
console.log(buf4);