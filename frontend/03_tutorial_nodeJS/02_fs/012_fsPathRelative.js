const fs = require('fs');

fs.writeFileSync('./index2.html','<h1>Hello World</h1>')

console.log(__dirname);

fs.writeFileSync(__dirname + '/index3.html','<h1>Hello World</h1>');