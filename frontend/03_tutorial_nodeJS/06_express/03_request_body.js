const express = require('express');

const app = express();

app.get('/request', (req,res) => {
    console.log(`${Date.now()} /request`);
    //原生操作
    console.log(req.method);
    console.log(req.url);
    console.log(req.httpVersion);
    console.log(req.headers);
    console.log('------------------');

    //express 操作
    console.log(req.path);
    console.log(req.query);
    console.log(req.ip);
    console.log(req.get('host'));


    res.send('Hello');

});
app.listen(3000,()=>{
    console.log(`${Date.now()} Server Start, listening on port 3000...`);
});