const fs = require('fs');

function ReadFileFunc(path){
    return new Promise((resolve, reject) => {
        fs.readFile(path,(err, data) => {
            if(err) reject(err);
            resolve(data);
        })
    })
}

ReadFileFunc('./1.txt').then(value =>{
    console.log(value.toString());
} ,reason => console.log(reason))