const express = require('express');
const bodyParser = require('body-parser');
const recordMiddleware = require('./utils/recordMiddleware');
const accounts = require('./routes/api/account');
const mongoose = require('mongoose');
mongoose.connect('mongodb://0.0.0.0/account',{useNewUrlParser:true})
    .then(()=> console.log('Database Connected'))
    .catch(err => console.log(err,'Database connected failed'))


const app = express();

app.use(recordMiddleware);
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));
app.use(express.static(__dirname + '/public'));
app.use('/account',accounts);

app.all('*',(req,res)=>{
    res.code = 404;
    res.send('<h1>404 Not Found</h1>');
})

app.listen(80,()=>{
    console.log(`${Date.now()} Server Started, listening on port 3000...`)
})
