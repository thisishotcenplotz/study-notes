//1. 导入http模块
const http = require('http');
let cnt = 1;

//2. 创建服务对象
const server = http.createServer((request,response)=>{
    console.log(`------------${cnt}:${Date.now()}--------------`);
    response.statusCode = 200;
    response.statusMessage = 'Yo!';
    response.setHeader('content-type','text/html;charset=utf-8');
    response.setHeader('abc','def');
    response.setHeader('server','habibi');

    response.write('1.xxx<br>');
    response.write('2.xxx<br>');
    response.write('3.xxx<br>');
    response.write('4.xxx<br>');
    response.end();

    cnt++;

});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})