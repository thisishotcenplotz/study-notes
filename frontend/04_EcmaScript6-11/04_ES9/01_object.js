function connect({host,port,...usr}){
    console.log(host);
    console.log(port);
    console.log(usr);
}

connect({
    host:'0.0.0.0',
    port:3306,
    user:'root',
    pwd:'root'
})