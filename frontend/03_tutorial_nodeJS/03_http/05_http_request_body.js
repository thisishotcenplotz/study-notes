//1. 导入http模块
const http = require('http');
const url = require('url');


//2. 创建服务对象
const server = http.createServer((request,response)=>{
    let res = url.parse(request.url,true);

    console.log(res.pathname);

    console.log(res.query);



});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})