//Buffer与字符串的转换
// let buf = Buffer.from([101,102,103,104,105,106]);
// console.log(buf.toString());

// let buf = Buffer.from('hello');
// console.log(buf[0].toString(2));


//溢出
// let buf = Buffer.from('hello');
// buf[0] = 361; //舍弃高位数字

//中文
let buf = Buffer.from('你好');
console.log(buf);