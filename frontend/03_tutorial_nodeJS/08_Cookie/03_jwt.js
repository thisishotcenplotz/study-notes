const jwt = require('jsonwebtoken');

let token = jwt.sign({
    username:'zhangsan'
},'hotcenplotz',{
    expiresIn: 60 //单位：秒
})

jwt.verify(token,'hotcenplotz',(err,data)=>{
    if(err){
        console.log('校验失败');
        return
    }
    console.log(data)
})