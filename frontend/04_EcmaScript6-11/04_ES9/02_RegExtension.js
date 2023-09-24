let str = '<a href="https://www.baidu.com">傻逼百度</a>'

//提取url与标签文本

const reg = /<a href="(?<url>.*)">(?<title>.*)<\/a>/
const rst = reg.exec(str);
console.log(rst['groups'])

// rst.forEach(item => console.log(item))