//1. 导入http模块
const http = require('http');
const fs = require('fs');
let cnt = 1;

//2. 创建服务对象
const server = http.createServer((request,response)=>{
    //需求描述
    //搭建HTTP服务，响应一个4行3列的表格，并且要求表格有各色换行效果，且点击单元格能显示高亮

    //获取请求url的路径
    let {pathname} = new URL(request.url,'http://127.0.0.1');
    console.log(`------------${cnt}:--->${pathname}--->${Date.now()}--------------`);
    if(pathname === '/'){
        let html = fs.readFileSync(__dirname + '/index.html');
        response.end(html);
    } else if (pathname === '/index.css'){
        let css = fs.readFileSync(__dirname + '/index.css');
        response.end(css);
    } else if (pathname === '/index.js'){
        let js = fs.readFileSync(__dirname + '/index.js');
        response.end(js);
    }else {
        response.statusCode = 404;
        response.end('<h1>404 NOT FOUND</h1>');
    }

    cnt++;


});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})