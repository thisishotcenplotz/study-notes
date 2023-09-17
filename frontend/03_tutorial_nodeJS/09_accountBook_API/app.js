const express = require('express');
const recordMiddleware = require('./utils/recordMiddleware');
const accounts = require('./routes/api/account');


const app = express();

app.use(recordMiddleware);
app.use('/account',accounts);

app.all('*',(req,res)=>{
    res.code = 404;
    res.send('<h1>404 Not Found</h1>');
})

app.listen(3000,()=>{
    console.log(`${Date.now()} Server Started, listening on port 3000...`)
})
