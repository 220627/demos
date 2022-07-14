//Get the 4 HTML elements that I want to populate with data (Dom Selection)
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype");
let pokenum = document.getElementById("pokenum");
let pokepic = document.getElementById("pokepic");

//set an event listener for when the button gets clicked
let button = document.getElementById("btn")
button.onclick = ajaxFunc //when the button is clicked, execute the ajaxFunc to get the data

//this function will send the user input to the server, and get a response back
function ajaxFunc(){

    //gather the user's input
    let num = document.getElementById("userInput").value; //.value is how we can get the user input  

    //initialize an XHR object, which is what lets us send/recieve data (over HTTP)
    let xhr = new XMLHttpRequest

    //this functionality will execute every time the event listener fires (when readystate changes)
    


}