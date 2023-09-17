const mongoose = require('mongoose');

mongoose.connect('mongodb://127.0.0.1:27017/bili');

mongoose.connection.once('open',()=>{

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

    //新增
    BookModel.create({
        name:'三国演义',
        author:'吴恩达',
        style:'恐怖',
        price:33.9
    });
    // BookModel.deleteOne({name:'水浒传'});

    // BookModel.updateOne({name:'水浒传'},{price:100})
    let data = BookModel.findOne({name: '水浒传'});
    console.log(data);
});
mongoose.connection.on('error',()=>{
    console.log('Error');
});
mongoose.connection.on('close',()=>{
    console.log('Closed');
});
