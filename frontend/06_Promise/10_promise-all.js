const fs = require('fs');
const util = require('util');

const myReadFile = util.promisify(fs.readFile);

let one = myReadFile('./1.txt');
let two = myReadFile('./2.txt');
let three = myReadFile('./3.txt');
let rst = Promise.all([one,two,three]);

rst.then(value =>{
    console.log(value.toString());
} ,reason => {
    console.log(reason)
})