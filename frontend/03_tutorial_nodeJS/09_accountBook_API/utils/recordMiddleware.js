
function recordMiddleware(req,res,next){
    let {url,ip} = req;
    if(url !== '/favicon.ico'){
        console.log(`${Date.now()}\t${ip}\t${url}\n`);
        next();
    }
}

module.exports = recordMiddleware
