const fs = require('fs');
fs.readFile('./book.txt',(err,data) =>{
    if(err) console.log(err.toString());
    else console.log(data.toString());
})