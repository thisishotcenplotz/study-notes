const fs = require('fs');
fs.rename('./book.txt','./boook.txt', err => console.log(err));