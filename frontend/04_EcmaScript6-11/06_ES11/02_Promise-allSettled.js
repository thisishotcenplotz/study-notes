const p1 = new Promise((resolve, reject) => {
    setTimeout(()=>{
        resolve('商品数据 -1');
    },1000)
})

const p2 = new Promise((resolve, reject) => {
    setTimeout(()=>{
        resolve('商品数据 -2');
    },1000)
})

const rst = Promise.allSettled([p1,p2])
console.log(rst);