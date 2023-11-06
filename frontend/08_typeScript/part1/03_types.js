//可以使用或来连接多个类型，来固定变量的类型范围
var gender;
//any表示的是任意类型，一个变量设置类型为any后相当于对该变量关闭了类型检测
//使用ts时，不建议使用any类型
//声明变量如果不指定类型，则ts解析器会自动判断变量的类型为any（隐式的any）
var d;
//unknown表示位置类型的值
var e;
e = 10;
e = '10';
e = false;
// 类型断言,可以用来告诉解析器变量的实际类型
var k = e;
var kk = e;
//never表示永远不会返回结果
function fn() {
    throw 'abc';
}
//在属性名后加？表示属性是可选的
var obj;
obj = {
    name: '孙悟空',
    age: 18,
    gender: 'male'
};
var fun;
fun = function fun(a, b) {
    return a + b;
};
var arr = [1, 2, 3, 4, 5];
var arr2 = ['a', 'b', 'c'];
//tuple
var h = ['Hello', 'World'];
//enum
var Gender;
(function (Gender) {
    Gender[Gender["Male"] = 1] = "Male";
    Gender[Gender["Female"] = 0] = "Female";
})(Gender || (Gender = {}));
var example = {
    name: '孙悟空',
    gender: Gender.Male
};
//
var xyj = {
    name: '孙悟空',
    age: 18
};
var swk = {
    name: '孙悟空',
    age: 18,
    skill: '大闹天宫'
};
console.log(swk);
