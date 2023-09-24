const express = require('express');
const session = require('express-session');
const MongoStore = require('connect-mongo');


const app = express();
app.use(express.static(__dirname + '/public'))

app.use(session({
    name:'sid', //设置cookie的name，默认值是connect.sid
    secret:'hotcenplotz', //设置密钥 ：加盐
    saveUninitialized:false, //是否为每次请求都设置一个cookie来存储session的id。一般为false，除非对匿名用户进行记录
    resave:true,// 是否在每次请求时重新保存session
    store:MongoStore.create({
        mongoUrl:'mongodb://127.0.0.1:27017/project'
    }),
    cookie:{
        httpOnly:true, //开启前端无法通过JS操作
        maxAge:1000 * 60 * 5 //设置session过期时间
    },
}))

app.get('/',(req,res)=>{
    res.redirect('/home.html')
});

app.get('/login',(req,res)=>{
   //username = admin & password = admin
    if(req.query.username === 'admin' && req.query.password === 'admin'){
        // setup session
        req.session.username = 'admin';
        res.send('登录成功');
    }else{
        res.send('登录失败')
    }
});
app.get('/cart',(req,res)=>{
    if(req.session.username){
        res.send('购物车页面，')
    }else{
        res.send('还未登陆');
    }
});
app.get('/logout',(req,res)=>{
    req.session.destroy(()=>{
        res.send('退出成功');
    })
})


app.listen(80);
