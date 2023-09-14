const express = require('express');
const router = express.Router();


router.post('/account/create',(req,res)=>{
    console.log('-----------------start----------------')
    console.log(req.data);
    console.log('-----------------end----------------')
    res.send('a');
})
module.exports = router;