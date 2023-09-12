const express = require('express');

const app = express();

app.get('/',(request,response)=>{
    console.log(`${Date.now()}`);
    response.end('Hello express');
});

app.listen(3000,()=>{
    console.log('service start, listening on port 3000....');
});