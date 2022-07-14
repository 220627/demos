console.log("======================================(Functions)")

//First we'll make a basic named function
//Because of hoisting we can call this method before we declare
helloWorld();

function helloWorld() {
    console.log("Hello World")
}

//Here's an anonymous function, it hasn't been named, but it's assigned a variable
//So basically, it's a function stored in a variable
var anon = function () {
    console.log("I'm an anonymous function")
}

anon();

//Arrow functions are basically like lambdas in Java
//takes in some argument(s) and performs some logic
var arrow = (name, age) => {
    console.log("Hi I'm an arrow function, my name is " + name + " I am " + age)
}

//when we actually call the arrow function, we give values for its parameters
arrow("Ben", 24);

//Callback functions functions that take another function as a parameter
function f1(x){
    console.log("Inside function 1")
    console.log("x = " + x)
}

function f2(y, callBack){
    console.log("Inside function 2")
    callBack(y) //so "callBack" is intended to be a function
    //which takes in y as its argument
}

f2(100, f1)

//Let's look at closures - an old way of acheiving encapsulation (data protection)
let HelloName = function (name) {
    return function (){
        console.log("hello " + name)
    }
}

//the nested function can access the name argument, but can't change it

//assigning the variable nameBen to the HelloName function 
let nameBen = HelloName("Ben");

nameBen(); //"hello Ben"

//BUT once we assign the HelloName variable, it can't ever change
HelloName = HelloName("Jamie");

HelloName();

//attempting to change the name argument again
let nameEggward = HelloName("EggWard");

HelloName(); //Hello Jamie prints out no matter what now

console.log("===========================================(Global Scopes)")

console.log(a); //prints undefined - 
//why not an error? the declaration was hoisted (var)

var a = 5; //here, we actually give the var a value 

//so now its value it visible
console.log(a);

//console.log(b);
//ERROR - b is a let, so its not hoisted, thus not visible

let b = 10;

console.log("now I can print the value of b: " + b);

//see an example of function hoisting above

console.log("===========================================(Local Scopes)")

//block scope----------------------

//undefined, it's a var, but undefined here
console.log(c);

if(true){
    var c = "I'm a var in a block. Block scoped!"
    console.log(c);
}

console.log(c); 
//Now, the variable is visible despite block scoped, since it's a var

if(true){
    let d = "I'm a let in a block. Block scoped!"
    console.log(d)
}

//console.log(d);
//another reference error!! let is not hoisted, thus out of scope here

//functional scope--------------------

function scopeTest(){
    console.log(e);
    var e = "I'm a var in functional scope!"
    console.log(e);
}

//console.log(e);
//We get a reference error here, even though e is a var

scopeTest();

//the main difference between block/functional is...
//vars are not visible outside of functions
//but they are visible outside of regular blocks.