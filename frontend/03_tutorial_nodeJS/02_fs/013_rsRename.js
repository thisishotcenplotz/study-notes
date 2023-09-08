const fs = require('fs');

const files = fs.readdirSync(__dirname +'/');

files.forEach(item=>{
    let fileType = item.split('.')[1];
    if(fileType === 'js'){
        let index = item.split('_')[0];
        fs.rename(`./${item}`,`./0${item}`,err =>{if(err) console.log(err)})
    }
})