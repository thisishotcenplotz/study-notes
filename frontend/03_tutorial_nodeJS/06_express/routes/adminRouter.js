const express = require('express');

const adminRouter = express.Router();

adminRouter.get('/admin',(req,res)=>{
    res.send('admin');
});

adminRouter.get('/setting',(req,res)=>{
    res.send('setting...');
});

module.exports = adminRouter;

