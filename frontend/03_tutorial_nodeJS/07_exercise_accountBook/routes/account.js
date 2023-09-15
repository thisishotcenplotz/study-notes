const fs = require('fs');
const path = require('path');
const express = require('express');
const {json} = require("express");
const shortid = require('shortid');
const router = express.Router();

const low = require('lowdb');
const FileSync = require('lowdb/adapters/FileSync')

const adapter = new FileSync(__dirname+'/../database/accountRecord.json');
const db = low(adapter)

router.get('/data',(req,res)=>{
    let data = db.get('accounts').value();
    let rst = '';
    let theType = ''
    data.forEach(item => {
        if(item["type"] === "-1"){
            theType = '支出';
        }else{
            theType = '收入';
        }
        let str = `
            <li class="data">
                <div class="data-dt">${item["bizdate"]}</div>
                <div class="data-detail">
                    <div class="data-detail-describe">${item["subject"]}</div>
                    <div class="data-detail-type">${theType}</div>
                    <div class="data-detail-amount">${item["amount"]}元</div>
                </div>
            </li>`;
        rst += str;
    });
    res.send(rst);
})

router.post('/account',(req,res)=>{
    let recordData = req.body;
    recordData['updatedAt'] = Date.now();
    db.get('accounts').unshift({id:shortid.generate(),...recordData}).write();
    console.log(`${Date.now()}: record added`);


    // fs.appendFileSync(path.resolve('./public/js/data/record.json'),JSON.stringify(recordData)+'\n');
    res.redirect('/success.html');
})
module.exports = router;