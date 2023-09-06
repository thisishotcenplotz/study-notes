const fs = require('fs');
fs.unlink('./bookCopy2.txt',err => console.log(err));
fs.unlink('./bookCopy.txt',err => console.log(err));