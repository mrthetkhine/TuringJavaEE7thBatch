const fs = require('node:fs');
console.log('start');
fs.readFile('hello.txt', 'utf8', (err, data) => {
    if(!err)
    {
        console.log('Data1 length ',data.toString().length);
    }
});
fs.readFile('hello2.txt', 'utf8', (err, data) => {
    if(!err)
    {
        console.log('Data2 length ',data.toString().length);
    }
});
console.log('end');