const fs = require('fs');

fs.stat('./boook.txt',(err,data)=>{
    if(err){
        console.log(err);
    }
    console.log(data);
})