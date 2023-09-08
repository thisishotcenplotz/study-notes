const fs = require('fs');

fs.writeFileSync('./index.html','love');
console.log(fs.readFileSync(__dirname + '/index.html').toString());


//这里主要讲相对路径和绝对路径的概念