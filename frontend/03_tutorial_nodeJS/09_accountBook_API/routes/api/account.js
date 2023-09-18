const express = require('express');
const mongo = require('../../database/db/mongo');
const accountRecord = require('../../database/model/accountRecord');
const mongoose = require("mongoose");
const router = express.Router();

router.get('/',async (req, res) => {
    let data = await accountRecord.find({});
    res.json(data)
});


router.post('/',(req,res)=>{

    accountRecord.create(req.body)
        .then(rst => console.log(`[Record Added] ${Date.now()} ${req.body.title}`));

    res.redirect('/success.html');

});
module.exports = router;