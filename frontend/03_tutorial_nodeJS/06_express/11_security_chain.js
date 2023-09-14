const express = require('express');

const app = express();

//生命中间件
app.use((req,res,next)=>{
    let referer = req.get('referer');
    if(referer){
        let url = new URL(referer);
        if(url.hostname !== 'localhost'){
            res.status(404)
                .send('<h1>Not Found</h1>');
            return;
        }
    }
    next();
});

app.use(express.static(__dirname + '/public'));


app.listen(3000,()=>{
    console.log(`${Date.now()}\tServer Start, listening on port 3000...`);
})