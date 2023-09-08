const fs = require('fs');
const path = require('path');

//resolve()
console.log(path.resolve(__dirname, './index.html'));

//sep  分隔符
console.log(path.sep);

//parse()
console.log(__filename);
console.log(path.parse(__filename));
//basename()
console.log(path.basename(__filename));
//dirname()
console.log(path.dirname(__filename));
//extname()
console.log(path.extname(__filename));