const express = require('express');

const app = express();

app.get('/response',(req,res)=>{
    //原生响应
    // res.statusCode = 404;
    // res.statusMessage = 'test';
    // res.setHeader('xxx','yyy');
    // res.write('Hello Express Response');
    // res.end();

    //express响应
    // res.status(500);
    // res.set('aaa','bbb');
    // res.send('你好 express');

    res.status(500)
        .set('xxx','yyy')
        .send('Hello Express Again')

});

app.listen(3000,()=>{
    console.log('Server Started, listening on port 3000...');
})