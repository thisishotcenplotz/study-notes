const express = require('express');
const app = express();

const recordMiddleware = require('./utils/middleware/record');

app.use(recordMiddleware);
app.use(express.static(__dirname + '/public'));


app.get('/',(req,res)=>{
   res.redirect('/home.html');
});
app.listen(80,()=>{
    console.log(`[Server Start]\t${Date.now()}`);
});