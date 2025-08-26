function display(message?:string)
{
    console.log('Message ',message);
}
display();
display('hello');

function display2(message='hello')
{
    console.log('Message ',message);
}
display2()
display2('hello hi');