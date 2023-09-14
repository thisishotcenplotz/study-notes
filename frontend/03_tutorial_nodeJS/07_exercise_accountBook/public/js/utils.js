const fs = require('fs');
const path = require('path');

function recordMiddleware(req,res,next){
    let {url,ip} = req;
    fs.appendFileSync(path.resolve(__dirname + '/data/access.log'),`${Date.now()}\t${ip}\t${url}\n`);
    next();
}

module.exports = {
    recordMiddleware
}