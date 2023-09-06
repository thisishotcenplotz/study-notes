//Buffer 与字符串的转换
let buf = Buffer.from([101,102,103,104,105]);
console.log(buf.toString());

// []

let buf2 = Buffer.from('Hello');
console.log(buf2[0]);
console.log(buf2[0].toString(2));


//溢出
let buf3 = Buffer.from('hello');
buf3[0] = 361; //自动舍弃高于8位的数字
console.log(buf3[0]);

//中文
let buf4 = Buffer.from('你好');
console.log(buf4);