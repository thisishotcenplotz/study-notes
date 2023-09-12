const express = require('express');
const fs = require('fs');
const path = require('path');

app = express();

//需求：针对 /admin /setting 的请求，要求URL携带 code=521 参数，如果未携带提示【暗号错误】


//全局中间键
function recordMiddleware(req,res,next){
    let {url,ip} = req;
    fs.appendFileSync(path.resolve(__dirname + '/access.log'),`${Date.now()} ${ip} ${url} \r\n`);
    next();
}

//路由中间键
let routerMiddleware = (req,res,next) =>{
    if(req.query.code === '521'){
        next();
    }else {
        res.send('暗号错误');
    }
}


app.use(recordMiddleware);
app.get('/home',(req,res)=>{
    res.send('前台首页');
});
app.get('/admin',routerMiddleware,(req,res)=>{
    res.send('后台首页');
});

app.get('/setting',routerMiddleware,(req,res) => {
   res.send('设置页面');
});

app.all('*',(req,res)=>{
    res.send('<h1>404 Not Found</h1>')
});

app.listen(3000,()=>{
    console.log('Server start, listening on port 3000...');
})