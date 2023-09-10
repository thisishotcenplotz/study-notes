//1. 导入http模块
const http = require('http');
let cnt = 1;

//2. 创建服务对象
const server = http.createServer((request,response)=>{
    console.log(`------------${cnt}:${Date.now()}--------------`);
    let {method} = request.method;
    let {pathname} = new URL(request.url,'http://127.0.0.1');

    response.setHeader('content-type','text/html;charset=utf-8');

    //判断路径
    if(method === 'GET' && pathname === '/login'){
        response.end('登录页面');
    }else if (method === 'GET' && pathname === '/reg'){
        response.end('注册页面');
    }else{
        response.end('not found');
    }


    cnt++;

});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})