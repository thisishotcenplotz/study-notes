let str = 'asdfadfasdf123123123123啊实打实地方324234234啦啦啦'


// const reg = /\d+(?=啦)/
// const rst = reg.exec(str);
// console.log(rst);

const reg = /(?<=么)\d+/
const result = reg.exec(str);
console.log(result);