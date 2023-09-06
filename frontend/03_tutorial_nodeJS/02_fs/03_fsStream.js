const fs = require('fs');
const ws = fs.createWriteStream('./book.txt');
ws.write('半亩方塘一鉴开\n');
ws.write('天光云影共徘徊\n');
ws.write('问渠那得清如许\n');
ws.write('为有源头活水来');
ws.close();