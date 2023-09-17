const mongoose = require('mongoose');
// 设置集合中文档表结构
let BookSchema = new mongoose.Schema({
    name: {
        type:String,
        required:true,
        unique:true
    },
    author: {
        type:String,
        default:'Somebody'
    },
    style:{
        type:String,
        enum:['言情','都市','玄幻','历史','恐怖']
    },

    price:Number
});

//创建模型对象，对文档进行操作
let BookModel = mongoose.model('books',BookSchema);

module.exports = BookModel;
