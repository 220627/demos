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
    xhr.onreadystatechange = function() {

        //if (and ONLY if) the response is ready AND our status code is 200 (OK)
        if(this.readyState === 4 && this.status === 200) {
            //take the JSON we get back and put it into a JS object (just like GSON on the backend)
            let data = JSON.parse(xhr.responseText) //get the strings of data into a JS object

            //see function below - takes our data variable and changes the HTML accordingly
            renderHTML(data);
        }
    }

    //xhr.open is a function that will open a connection to the server to send requests
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/" + num);

    //xhr.send will actually send the request.
    xhr.send();

    //so every time the button is clicked, the ajax function will run and send a request
    //after the request is sent, we should get a pokemon object from pokeapi

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

        //we could've done pokepic.src as well, but maybe not best practice
        //but it's probably fine here since img tags have the src attribute

    }

}