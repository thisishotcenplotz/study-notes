const fs = require('fs');

fs.writeFileSync('./index.html','love');
console.log(fs.readFileSync(__dirname + '/index.html').toString());