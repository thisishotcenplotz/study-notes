/*需求：
* 创建一个文件，写入一个txt文件*/
const fs = require('fs');

const text = '三人行，必有我师焉';

fs.writeFile('./test0.txt',text,(err)=>{
    if(err){
        console.log(err);
    }else{
        console.log('text written');
    }
});
