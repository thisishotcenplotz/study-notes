const express = require('express')
app = express()

app.get('/server',(req,res)=>{
    res.setHeader('access-Control-Allow-Origin','*');

    res.send('Hello Ajax');
})

app.all('/server',(req,res)=>{
    let randomNumber = Math.floor(Math.random()*10000);
    res.setHeader('Access-Control-Allow-Origin','*');
    res.setHeader('Access-Control-Allow-Headers','*');
    res.send(randomNumber.toString());
})

app.post('/json-server',(req, res) => {
    let randomNumber = Math.floor(Math.random()*10000);
    res.setHeader('access-Control-Allow-Origin','*');
    let str = JSON.stringify({
        'random':randomNumber
    })
    res.send(str)

})
app.post('/err',(req, res) => {
    res.setHeader('Access-Control-allow-Origin','*');
    setTimeout(()=>{
        res.send('This is Error');
    },3000)
})

app.get('/jquery',(req, res) => {
    res.setHeader('Access-Control-allow-Origin','*');
    res.setHeader('Access-Control-Allow-Headers','*');
    res.json({
        'name':'Hotcenplotz',
        'words':"Fuck Stupid Wuliangye..."
    });
})

app.post('/jquery',(req, res) => {
    res.setHeader('Access-Control-allow-Origin','*');
    res.setHeader('access-Control-Allow-Headers','*');
    res.json({
        'words':'Shitty Wuliangye!'
    });
})



app.all('/axios-server',(req, res) => {
    res.setHeader('Access-Control-allow-Origin','*');
    res.setHeader('access-Control-Allow-Headers','*');
    res.send('Hello Axios')
})


app.all('/fetch-server',(req, res) => {
    res.setHeader('Access-Control-Allow-Origin','*');
    res.setHeader('Access-Control-Allow-Headers','*');
    let data = {
        name:'george',
        age:33
    }
    res.send(JSON.stringify(data))
})

app.all('/check-username',(req, res) => {
    const data = {
        exist:1,
        msg:'用户名已存在'
    }

    let str = JSON.stringify(data);
    res.end(`handle(${str})`);
})

app.listen(8888,()=>{
    console.log('Server Start! Listening on port 8888....')
});