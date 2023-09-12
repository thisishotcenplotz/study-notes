const express = require('express');
const {response} = require("express");

const app = express();

app.get('/', (request,response) => {
    console.log(`${Date.now()}:/`);
    response.send('Home');
});

app.post('/login',(request, response)=>{
    console.log(`${Date.now()}:/login`);
    response.end('login....');
});

app.all('/test',(req,res) => {
    console.log(`${Date.now()}:/login`);
    res.end('test~');
});

app.all('*', (req,res) => {
    console.log(`${Date.now()}: *`);
    res.end('404 Not Found!');
})

app.listen(3000,()=>{
    console.log('server started, listening on port 3000');
})


