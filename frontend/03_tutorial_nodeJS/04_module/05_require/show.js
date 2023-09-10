//以下内容为伪代码
const fs = require('fs');

function require(){
    let absolutePath = path.resolve(__dirname,file);

    if(caches[absolutePath]){
        return caches[absolutePath];
    }

    let code = fs.readFileSync(absolutePath).toString();

    let module = {};
    let exports = module.exports = {};
    (function (exports,require,module,__filename,__dirname) {
            const test = {
                'name': '这是啥'
            }
            module.exports = test;

            console.log(arguments.callee.toString());
        }
    )(exports,require,module,__filename,__dirname)


    caches[absolutePath] = module.exports;
    return module.exports;
}

const m = require('./me.js');
const path = require("path");