const mongoose = require('mongoose');

// 设置集合中文档表结构
let AccountRecordSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true,
        unique: true
    },
    time: {
        type: Date,
    },
    type: {
        type: Number,
        default: -1
    },
    account: {
        type: Number,
        required: true
    },
    remarks:{
        type:String
    }
});

//创建模型对象，对文档进行操作
let AccountRecord = mongoose.model('movie', AccountRecordSchema);

module.exports = AccountRecord;