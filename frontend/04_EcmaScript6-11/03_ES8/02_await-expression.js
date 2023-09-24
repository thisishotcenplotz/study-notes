const p = new Promise((resolve, reject) => {
    resolve('成功的用户数据');
    // reject('失败了。')
});

async function fn(){
    try{
        let rst = await p;
        console.log(rst);
    }catch (e){
        console.log(e);
    }
}

fn();
