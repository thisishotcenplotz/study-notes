const fs = require('fs');
const rs = fs.createReadStream('./book.txt');

rs.on('data',chunk => {
    console.log(chunk.toString())
})
rs.on('end',()=>{
    console.log('Done');
})