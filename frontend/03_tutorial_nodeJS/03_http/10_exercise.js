//1. 导入http模块
const http = require('http');
const fs = require('fs');
let cnt = 1;

//2. 创建服务对象
const server = http.createServer((request,response)=>{
    console.log(`------------${cnt}:${Date.now()}--------------`);
    //需求描述
    //搭建HTTP服务，响应一个4行3列的表格，并且要求表格有各色换行效果，且点击单元格能显示高亮
    let html = fs.readFileSync(__dirname+'/record.html');

    response.end(html);
    cnt++;


});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})