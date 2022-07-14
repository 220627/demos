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

//Assigning a variable that applies to our button
let myButton = document.getElementById("b1")

//event listeners take in the event we're listening for, and the function to execute.
myButton.addEventListener("click", domFunc)

//declare the domFunc
function domFunc() {
    //I want to change some of the content we see on our webpage
    myButton.textContent = "Thanks for the click!" //textContent accesses the element's text

    //we can add an eventListener after DOM selection
    document.getElementById("p3").textContent = "NOW I HAVE CONTENT >:)"
}

//there a shorter to add eventListeners

//get the h3 using DOM selection
let header = document.getElementById("header")

//every time we mouse over our header the hover function will execute
header.onmouseover = hoverFunc

function hoverFunc() {
    header.textContent = "don't touch me!!"
}

//and then, every time our mouse leaves the header, the release function will execute

header.onmouseleave = releaseFunc

function releaseFunc(){
    header.textContent = "why did you leave me :("
}