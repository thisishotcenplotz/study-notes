class Person{
    name;
    #age;
    #weight;
    constructor(name,age,weight) {
        this.name = name;
        this.#age = age;
        this.#weight = weight;
    }
    get getAge(){
        return this.#age
    }
}
let girl = new Person('紫琪',18,45);
console.log(girl.name);
console.log(girl.getAge);