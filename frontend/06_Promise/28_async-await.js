const fs = require('fs');
const { promisify } = require('util')

async function main(){
    let FileStream = promisify(fs.readFile);
    try{
        let one = await FileStream('./1.txt');
        let two = await FileStream('./2.txt');
        let three = await FileStream('./3.txt');
        console.log(one + two + three);
    }catch (e){
        console.log(e);
    }
}


