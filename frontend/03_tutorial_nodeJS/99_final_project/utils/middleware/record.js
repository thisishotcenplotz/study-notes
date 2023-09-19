function GlobalMiddlewareRecord(req,res,next){
    let {url,ip} = req;
    if(url !== '/favicon.ico'){
        // console.log(`[Route Record]${Date.now()}\t${ip}\t${url}\n`);n
        console.log(`[Server Record]\t${Date.now()}\t${ip}\t${url}\n`);
        next();
    }
}

module.exports = GlobalMiddlewareRecord;