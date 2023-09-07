/*
* NodeJS无法使用的部分
*/

// // BOM
// console.log(window);
// console.log(navigator);
// console.log(history);
// console.log(location);
//
// //BOM
// console.log(document);
//
// //AJAX
// let xhr = new XMLHttpRequest();


/*
* NodeJS 可以使用的
* */


setInterval(()=>{
    console.log('this is a test');
},1000)

//global 顶级对象