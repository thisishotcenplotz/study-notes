let m = new Map()


m.set('name','孙悟空')
m.set('change',()=>{
    console.log('斗战胜佛');
})
let key = {
    'school':'Target University'
};
m.set(key,['Harvard University','MIT','Cal Tech','Stanford University'])

console.log(m.size);
m.delete('name');

console.log(m.get(key));

// m.clear()

for (let keyElement of m) {
    console.log(keyElement);
}
console.log(m);