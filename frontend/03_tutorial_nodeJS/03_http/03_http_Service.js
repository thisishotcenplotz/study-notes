//1. 导入http模块
const http = require('http');


//2. 创建服务对象
const server = http.createServer((request,response)=>{
    //获取请求的方法
    const requestMethods = request.method;

    //获取请求url
    const requestURL = request.url;

    //获取http协议版本号
    const requestHTTP = request.httpVersion;

    //获取请求头
    const requestHead = request.headers;

    // 获取请求头中的host
    const requestHost = request.headers.host;

    response.end('Hello World');
});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})