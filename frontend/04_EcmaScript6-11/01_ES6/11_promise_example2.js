const fs = require('fs');

const p = new Promise((resolve, reject) => {
    fs.readFile(__dirname + '/study1.txt',(err, data) => {
        resolve(data);
    })
})
p.then(value => {
    return new Promise((resolve, reject) => {
        fs.readFile(__dirname + '/study2.txt',(err, data) => {
            resolve([value,data])
        })
    })
})
.then(value => {
    return new Promise((resolve, reject) => {
        fs.readFile(__dirname + '/study3.txt',(err, data) => {
            value.push(data)
            resolve(value)
        })
    })
})
.then(value => {
    console.log(value.join('/n'))
})