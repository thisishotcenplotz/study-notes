//1. 导入http模块
const http = require('http');
const fs = require('fs');
const path = require('path');
let mimes = {
    html:'text/html',
    css:'text/css',
    js:'text/javascript',
    png:'image/png',
    jpg:'image/jpeg',
    gif:'image/gif',
    mp4:'video/mp4',
    mp3:'audio/mpeg',
    json:'application/json'
}
let cnt = 1;

//2. 创建服务对象
const server = http.createServer((request,response)=>{
    //需求描述
    //搭建HTTP服务，响应一个4行3列的表格，并且要求表格有各色换行效果，且点击单元格能显示高亮

    if(request.method !== 'GET'){
        response.statusCode = 405;
        response.end('<h1>405 METHOD NOT ALLOWED</h1>');
        return;
    }

    //获取请求url的路径
    let {pathname} = new URL(request.url,'http://127.0.0.1');
    let root = __dirname + '/page';
    let filePath = root + pathname;

    fs.readFile(filePath,(err,data)=>{
        if(err){
            switch (err.code){
                case 'ENOENT':
                    response.statusCode = 404;
                    response.end('<h1>404 NOT FOUND</h1>');
                    break
                case 'EPERM':
                    response.statusCode = 403;
                    response.end('<h1>403 FORBIDDEN</h1>');
                    break
                default:
                    response.statusCode = 500;
                    response.end('<h1>INTERNAL SERVER ERROR</h1>');

            }
            response.setHeader('content-type','text/html;charset=utf-8');
            response.statusCode = 500;
            response.end('Failed');
            return;
        }
        let ext = path.extname(filePath).slice(1);
        let type = mimes[ext];
        if(type){
            response.setHeader('content-type',type + ';charset=utf-8');
        }else{
            response.setHeader('content-type','application/octet-stream');
        }
        response.end(data);
    });


    cnt++;

    console.log(`------------${cnt}:--->${pathname}--->${Date.now()}--------------`);

});
//3.监听端口，启动服务
server.listen(80,()=>{
    console.log('server start ...');
})