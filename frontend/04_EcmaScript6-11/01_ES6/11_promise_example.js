const fs = require('fs');

//调用方法读取文件
// fs.readFile(__dirname+'/study1.txt',(err,data)=>{
//     if(err) throw err;
//     console.log(data.toString());
// })

//使用promise封装

const p = new Promise((resolve, reject)=>{
    fs.readFile(__dirname+'study1.txt',(err, data)=>{
        if (err) reject(err);
        resolve(data);
    });
});

p.then((value)=>{
    console.log(value.toString())
},(reason)=>{
    console.log('读取失败');
})

const a = new Promise((resolve, reject)=>{

}).then(value => {},reason => {})
    .then(value => {},reason => {})
