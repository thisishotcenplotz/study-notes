let str = `
<ul>
    <li>
        <a>肖申克的救赎</a>
        <p>dt : 1994-09-10</p>
    </li>
    <li>
        <a>阿甘正传</a>
        <p>dt : 1994-07-06</p>
    </li>
</ul>`;

// const reg = /<li>\s+<a>(.*?)<\/a>\s+<p>(.*?)<\/p>/
// console.log(reg.exec(str));

const reg = /<li>.*?<a>(.*?)<\/a>.*?<p>(.*?)<\/p>/gs;
let rst;
let data = [];
while (rst = reg.exec(str)){
    data.push(rst)
}
console.log(data);