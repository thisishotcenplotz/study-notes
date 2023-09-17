const mongoose = require('mongoose');

mongoose.connect('mongodb://127.0.0.1:27017/bili');

mongoose.connection.once('open',()=>{
    console.log('Connected');
});
mongoose.connection.on('error',()=>{
    console.log('Error');
});
mongoose.connection.on('close',()=>{
    console.log('Closed');
});

setTimeout(()=>{
    mongoose.disconnect();
},2000)