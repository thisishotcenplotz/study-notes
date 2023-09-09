//1. 导入http模块
const http = require('http');


//2. 创建服务对象
const server = http.createServer((request,response)=>{
    response.setHeader('content-type','text/html;charset=utf-8');
    // response.end('Hello HTTP Server');
    response.end('你好，世界！');

});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})