const express = require('express');
const moment = require('moment');
const mongoDB = require('../../database/db/mongo');
const accountRecord = require('../../database/model/accountRecord');
const router = express.Router();

router.get('/',(req,res)=>{
    accountRecord
        .find()
        .sort({time: -1})
        .then((err,data) => {
            if(err){
                res.json({
                    code:1001,
                    msg:'Failed',
                    data:null
                });
                return;
            }
            res.json({
                code: '0000',
                msg: 'Data read',
                data: data
            })
        })
});

router.post('/',(req,res)=>{
    accountRecord.create({
        ...req.body,
        time:moment(req.body.time).toDate()
    },(err,data)=>{
        if(err){
            res.status(500).send('failed to add data');
            return;
        }
        res.json({
            code:'0000',
            msg:'Created',
            data:data

        })
    })
});
module.exports = router;