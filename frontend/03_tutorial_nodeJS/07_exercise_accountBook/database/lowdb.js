const low = require('lowdb');
const FileSync = require('lowdb/adapters/FileSync')

const adapter = new FileSync('accountRecord.json');
const db = low(adapter)