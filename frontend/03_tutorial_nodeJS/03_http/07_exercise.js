//1. 导入http模块
const http = require('http');
let cnt = 1;

//2. 创建服务对象
const server = http.createServer((request,response)=>{
    console.log(`------------${cnt}:${Date.now()}--------------`);
    let url = new URL(request.url,'http://127.0.0.1');
    cnt++;

});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})