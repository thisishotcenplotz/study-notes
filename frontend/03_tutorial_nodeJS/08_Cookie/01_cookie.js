const express = require('express');
const cookieParser = require('cookie-parser');

const app = express();

app.use(cookieParser());

app.get('/set-cookie',(req,res)=>{
    // res.cookie('name','zhangsan'); // 会在浏览器关闭的时候销毁
    res.cookie('name','lisi',{maxAge: 60 * 1000}); // 设置cookie生命周期，单位毫秒
    res.cookie('theme','blue');
    res.send('Home');
});

//删除Cookie
app.get('/remove-cookie',(req,res)=>{
    res.clearCookie('name');
    res.send('删除成功');
});

app.get('/get-cookie',(req,res)=>{
    console.log(req.cookies);
    res.send(`欢迎！${req.cookies.name}`);
});

app.listen(80);