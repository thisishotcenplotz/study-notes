
function recordMiddleware(req,res,next){
    let {url,ip} = req;
    console.log(`${Date.now()} ${ip} ${url} \r\n`);
    next();
}

module.exports = recordMiddleware;