function processData(data:number|string)
{
    if(typeof data === "number")
    {
        data = data * 2;
    }
    else
    {
        data = data.toUpperCase();
    }
      console.log('Data ',data);
}
processData(10);
processData('Hello');