const express = require('express');
const utils = require(__dirname+'/public/js/utils');
const accountRouter = require('./routes/account');
app = express();

app.use(express.json());
app.use(express.urlencoded({extended:false}));
app.use(utils.recordMiddleware);
app.use(express.static(__dirname+'/public'));
app.use(accountRouter);
app.listen(3000,()=>{
    console.log(`${Date.now()} Server Start,listening on port 3000...`);
})
