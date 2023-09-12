const express = require('express');
const {singers} = require('./singers.json');

const app = express();

app.get('/singer/:id.html',(req,res)=>{
    let {id} = req.params;
    let rst = singers.find(item =>{
        if(item.id === Number(id)) return true;
    });
    if(!rst){
        res.end('404 NOT FOUND');
    }
    
    res.end(`
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>
        <body>
            <h2>${rst.singer_name}</h2>
            <img src='${rst.singer_pic}' style="height: 300px;">
        </body>
        </html>
    `);
});

app.listen(3000,()=>{
    console.log(`${Date.now()} Server started, listening port 3000...`);
})