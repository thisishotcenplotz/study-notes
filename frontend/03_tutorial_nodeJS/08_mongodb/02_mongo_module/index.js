const db = require('./db/db');
const bookModel = require('./models/BookModel');

db(()=>{
    bookModel.create({
        name:'金瓶梅哦',
        author:'李宏毅',
        style:'历史',
        price:44.9
    });
    console.log('Added');
})

