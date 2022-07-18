//PokeAPI base URL - making a variable to hold the base URL, which will make for cleaner code
//we will append an endpoint based on the user input
const api = "https://pokeapi.co/api/v2/pokemon/"

//Get the 5 HTML elements that I want to populate with data (Dom Selection)
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype");
let pokenum = document.getElementById("pokenum");
let pokepic = document.getElementById("pokepic");
let pokepic2 = document.getElementById("pokepic2");

//when the user clicks the button, execute the fetchData function
document.getElementById("btn").onclick = fetchData
//this is a cleaner way to add an event listener to an element

//compare this function to the ajaxFunc() in HelloAjax... this is much cleaner

//This function will return our pokemon data
//It will use the Fetch api to return a promise object
//This promise object will get filled with data for the pokemon we requested
async function fetchData(){

    //put the user input into a variable
    let userInput = document.getElementById("userInput").value

    //use the fetch() method to send a request to the PokeAPI with the user's input
    let response = await fetch(api + userInput) //await pauses the function until data comes back
    //fetch sends a GET request by default, this one takes our base URL plus the user's input

    //now we need to check if the promise returned successfully
    if(response.status === 200) { 
        let data = await response.json() //turn the JSON data into JS
        renderHTML(data) //send it to the renderHTML() function to get rendered.
    } else {
        document.getElementById("header").innerHTML = "It Got Away! Try again..."
    }


//this function will manipulate the DOM based on the user's input & response from the server
function renderHTML(data) {

    //populate the previously empty HTML elements with pokemon data
    pokename.innerText = data.name
    pokenum.innerText = data.id 
    poketype.innerText = data.types[0].type.name
    //we want to check if there's a second type, and render it if so
    if(data.types[1]){
        poketype.innerText += (" & " + data.types[1].type.name) 
    }

    //pokepic will be a little different, we need to set the src attribute of the <img> tag
    pokepic.setAttribute("src", data.sprites.front_default)

    pokepic2.setAttribute("src", data.sprites.front_shiny)

 }

}