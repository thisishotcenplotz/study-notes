const fs = require('fs');
fs.mkdir('./test',err => console.log(err));
fs.readdir('./test',err => console.log(err));
fs.rmdir('./test',err => console.log(err));