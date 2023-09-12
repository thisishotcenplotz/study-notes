const express = require('express');
const fs = require('fs');
const path = require('path');

app = express();

//需求：记录每一个请求的url和IP地址

function recordMiddleware(req,res,next){
    let {url,ip} = req;
    fs.appendFileSync(path.resolve(__dirname + '/access.log'),`${Date.now()} ${ip} ${url} \r\n`);
    next();
}
app.use(recordMiddleware);
app.get('/home',(req,res)=>{
    res.send('前台首页');
});
app.get('/admin',(req,res)=>{
    res.send('后台首页');
});

app.all('*',(req,res)=>{
    res.send('<h1>404 Not Found</h1>')
});

app.listen(3000,()=>{
    console.log('Server start, listening on port 3000...');
})