
module.exports = function (success,error){
    if(typeof error !== 'function'){
        error = ()=>{
            console.log('连接失败...');
        }
    }


    const mongoose = require("mongoose");

    mongoose.set('strictQuery',true);
    const {DBHOST,DBPORT,DBNAME} = require('../config/config');

    mongoose.connect(`mongodb://${DBHOST}:${DBPORT}/${DBNAME}`);

    mongoose.connection.once('open',()=>{
        success();
    });

    mongoose.connection.on('error',()=>{
        error();
    });

    mongoose.connection.on('close',()=>{
        console.log('Connection Closed')
    });
}