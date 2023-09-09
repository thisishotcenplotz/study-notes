//1. alloc
let buf = Buffer.alloc(10);
console.log(buf)
//2. allocUnsafe
let buf2 = Buffer.allocUnsafe(10);
console.log(buf2);
//3. from
let buf3 = Buffer.from('Hello');
console.log(buf3);
let buf4 = Buffer.from([101,102,103,104,105,106]);
console.log(buf4);