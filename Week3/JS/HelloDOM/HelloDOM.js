console.log("===========================(DOM Selection/Manipulation)")

//I want all my divs with class = coolClassName (DOM selection)
let divElements = document.getElementsByClassName("coolClassName")

//we can access the objects in the divElements array
console.log(divElements)

let firstDiv = divElements[0];

console.log(firstDiv)

//we can set attributes of elements directly (DOM Manipulation), though it's not best practice
//there's an actual style object that we can set properties for
firstDiv.setAttribute("style", "background-color:pink; font-family:calibri")

console.log("====================================(Events)")

