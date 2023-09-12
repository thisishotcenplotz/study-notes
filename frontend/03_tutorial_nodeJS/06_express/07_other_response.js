const express = require('express');

const app = express();

app.get('/other',(req,res)=>{
    //重定向
    // res.redirect('https://www.baidu.com');

    //下载响应
    // res.download(__dirname + '/singers.json');

    //json
    // res.json({
    //     'slogon':'让天下没有难学的技术'
    // })

    //响应文件内容
    res.sendFile(__dirname + '/test.html');

})


app.listen(3000,()=>{
    console.log('server started');
})