console.log("=========================(Class Declaration)")
 
class Baby{
     //This is how we do constructors in JS - similar to Java, they initialize objects with variable values
    constructor(name, age, stinky){
        this.name = name;
        this.age = age;
        this.stinky = stinky;
    }

    //a function that lets the baby cry
    cry(){
        alert(this.name + " goes WAHHHAHAHHHHHHHHHH!!!!!!!")
    }
}

//Instantiate a Baby object
let baby1 = new Baby("Ben", 1, false);

//print out the contents of the baby object
console.log(baby1)

console.log("=========================(Class Expression)")

//defining a Class by assigning it to a variable
//notice how baby and Baby can coexist, JS lets us do this

let baby = {
    name:"Chad",
    age:25,
    stinky:false,

    cry() {
        alert("WAAAAAAAAAH from the Class Expression")
    }
}

console.log(baby)

//make some babies cry
baby1.cry()
baby.cry()

console.log("======================(Inheritance)")

//here's a new object using a Class Expression
//use the __proto__ property to declare parent classes
let roboBaby = {
    __proto__:baby, //this makes the baby class the parent of roboBaby
    isRobotic:true //it can also have its own variables
}

//we can access all the fields from the baby class (Inheritance!)
console.log(roboBaby.name);

//we can also change the inherited variables
roboBaby.name = "BabyBot"

console.log(roboBaby.name);

//override the cry function from the baby class
roboBaby.cry = function() {
    alert("beep boop")
}

roboBaby.cry(); 








