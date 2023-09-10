//1. 导入http模块
const http = require('http');
let cnt = 1;

//2. 创建服务对象
const server = http.createServer((request,response)=>{
    console.log(`------------${cnt}:${Date.now()}--------------`);
    //需求描述
    //搭建HTTP服务，响应一个4行3列的表格，并且要求表格有各色换行效果，且点击单元格能显示高亮


    cnt++;
    response.end('table');


});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})