const mongoose = require("mongoose");
module.exports = function (success,error){
    if(typeof error !== 'function'){
        error = ()=> {
            console.log(`${Date.now()} Connection Failed`);
        }
    }

    const mongoose = require("mongoose");

    mongoose.set('strictQuery',true);

    mongoose.connect(`mongodb://0.0.0.0:27017/account`);

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