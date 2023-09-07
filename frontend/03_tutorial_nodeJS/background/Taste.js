class Animal{
    constructor(name,age,gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    sayHello(){
        console.log(`Hello! this is ${this.name}`)
    }
}

let dog = new Animal('孙悟空',18,'male');


for (let i = 0; i < 5; i++) {
    dog.sayHello();
}
