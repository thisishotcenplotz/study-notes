//可以使用或来连接多个类型，来固定变量的类型范围
let gender: 'male' | 'female' | false;


//any表示的是任意类型，一个变量设置类型为any后相当于对该变量关闭了类型检测
//使用ts时，不建议使用any类型
//声明变量如果不指定类型，则ts解析器会自动判断变量的类型为any（隐式的any）
let d: any;


//unknown表示位置类型的值
let e: unknown;
e = 10;
e = '10';
e = false;

// 类型断言,可以用来告诉解析器变量的实际类型
let k = e as string;
let kk = <string>e


//never表示永远不会返回结果
function fn(): never {
    throw 'abc'
}

//在属性名后加？表示属性是可选的
let obj: {
    name: string,
    age?: number,
    [propName: string]: any
}
obj = {
    name: '孙悟空',
    age: 18,
    gender: 'male'
}

let fun: (a: number, b: number) => number;
fun = function fun(a, b) {
    return a + b;
}

let arr: number[] = [1, 2, 3, 4, 5];
let arr2: Array<string> = ['a', 'b', 'c'];


//tuple
let h: [string, string] = ['Hello', 'World'];

//enum
enum Gender {
    Male = 1,
    Female = 0
}

let example: { name: string, gender: Gender } = {
    name: '孙悟空',
    gender: Gender.Male
}

//
let xyj:{name:string} & {age:number} = {
    name:'孙悟空',
    age:18
}

//类型别名
type xy = {name:string,age:number,[propName: string]: any}

let swk:xy = {
    name:'孙悟空',
    age:18,
    skill:'大闹天宫'
}
console.log(swk);