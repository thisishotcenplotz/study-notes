const express = require('express');

const app = express();

app.get('/:id.html',(req,res)=>{
    console.log(req.params.id);
    res.setHeader('content-type','text/html;charset=utf-8');
    res.end('Product Detail');
});

app.listen(3000,()=>{
    console.log(`${Date.now()} server started, listening port 3000...`);
});
