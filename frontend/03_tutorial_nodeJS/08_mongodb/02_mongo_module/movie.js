const mongoose = require('mongoose');
const MovieModel = require('./models/MovieModel');
const db = require('./db/db');

db(()=>{
    MovieModel.create({
        title:'让子弹飞',
        director:'姜文'
    })
    console.log('Added')
})