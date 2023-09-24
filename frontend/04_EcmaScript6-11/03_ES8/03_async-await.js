const fs = require('fs');

function readBook(num){
    return new Promise((resolve, reject) => {
        let dir = __dirname + `/books/study${num}.txt`;
        fs.readFile(dir,(err, data) => {
            if (err) reject(err);
            resolve(data);
        });
    });
}

async function main(){
    let a = await readBook(1);
    let b = await readBook(2);
    let c = await readBook(3);
    console.log([a.toString(), b.toString(), c.toString()].join('\n'));
}
main()