const express = require('express');
const homeRouter = require('./routes/homeRouter');
const adminRouter = require('./routes/adminRouter');
const recordMiddleware = require('./routes/utils');
const app = express();

app.use(recordMiddleware);
app.use(express.static(__dirname + '/public'));
app.use(homeRouter);
app.use(adminRouter);
app.listen(3000,()=>{
    console.log(`${Date.now()} Server Started, listening on port 3000...`);
})

