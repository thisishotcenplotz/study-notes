const mongoose = require('mongoose');

// 设置集合中文档表结构
let MovieSchema = new mongoose.Schema({
    title: {
        type:String,
        required:true,
        unique:true
    },
    director: {
        type:String,
        default:'Somebody'
    }
});

//创建模型对象，对文档进行操作
let MovieModel = mongoose.model('movie',MovieSchema);

module.exports = MovieModel;