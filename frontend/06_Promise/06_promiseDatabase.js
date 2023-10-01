const mongoose = require('mongoose');
const {Mongoose} = require("mongoose");

new Promise((resolve, reject) => {
    mongoose.connect('mongodb://127.0.0.1:27017/promise');
    mongoose.connection.on('open', () => {
        resolve('链接成功');
    })
    mongoose.connection.on('error', () => {
        reject();
    })
}).then(value => {
    const noteSchema = new mongoose.Schema({
        title: String,
        content: String
    });
    const nodeModel = mongoose.model('notes', noteSchema);

    nodeModel.find().then(value => {
        console.log(value)
    },reason => {
        console.log(reason)
    })
})
