//实现文件复制功能
const fs = require('fs');


// const data = fs.readFileSync('./book.txt');
// fs.writeFileSync('./bookCopy.txt',data);



const rs = fs.createReadStream('./book.txt');
const ws = fs.createWriteStream('./bookCopy2.txt');
rs.on('data',chunk =>{
    ws.write(chunk);
})

// rs.pipe(ws)