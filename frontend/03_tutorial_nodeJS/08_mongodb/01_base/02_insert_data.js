const mongoose = require('mongoose');

mongoose.connect('mongodb://127.0.0.1:27017/bili');

mongoose.connection.once('open',()=>{

    // 设置集合中文档表结构
    let BookSchema = new mongoose.Schema({
        name: String,
        author: String,
        price:Number
    });

    //创建模型对象，对文档进行操作
    let BookModel = mongoose.model('books',BookSchema);

    //新增
    BookModel.create({
        name:'水浒传',
        author:'李飞飞',
        price:21.9
    });
});
mongoose.connection.on('error',()=>{
    console.log('Error');
});
mongoose.connection.on('close',()=>{
    console.log('Closed');
});
