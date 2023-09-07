const fs = require('fs');
const text = '\n择其善者而从之，其不善者而改之';

fs.appendFile('./test0.txt',text,err => console.log(err));