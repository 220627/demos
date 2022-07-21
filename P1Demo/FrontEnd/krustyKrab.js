const url = "http://localhost:3000"; //putting our base URL in a variable for cleaner code below
//This will be used in fetch requests to make requests to our java server.

//add an event listener to give our buttons some functionality (DOM Selection)
document.getElementById("getEmployeeButton").onclick = getEmployees //this button will GET all employees
document.getElementById("loginButton").onclick = loginFunction //this button will send a user's login credentials
document.getElementById("updateButton").onclick = updateSalary //this button will send data that updates a role salary


//getEmployees is an async function which uses a fetch request to get employees from our server------------------------------------------
//remember, async makes a function return a Promise object (which fetch requests return)
async function getEmployees(){

    //a fetch request for employee data from the server
    //by default, fetch requests send GET requests. (see how to send others in login function below)
    let response = await fetch(url + "/employees")

    //log the response in the console just to see the response object (good for debugging)
    console.log(response)

    //control flow on the status code to determine whether or not the request was successful
    if(response.status === 200){

        //translate the JSON we get in the response body and turn it into a JS object
        //remember, .json() is the function that takes JSON and turns it into JS.
        let data = await response.json();

        //For every employee objects we get back from our fetch request, put it in the table
        //"employee" is the variable name we're giving to each piece of data returned
        for(let employee of data){

            //create a table row for the incoming employee
            let row = document.createElement("tr")

            //create a data cell (td) for each employee field
            let cell = document.createElement("td")
            //fill the cell with the appropriate data
            cell.innerHTML = employee.employee_id
            //add the new cell to the row
            row.appendChild(cell)

            //we'll do this^^^ for each column in the employee object

            //cell2 - first_name
            let cell2 = document.createElement("td")
            cell2.innerHTML = employee.first_name
            row.appendChild(cell2)

            //cell3 - last_name
            let cell3 = document.createElement("td")
            cell3.innerHTML = employee.last_name
            row.appendChild(cell3)

            //cell4 - role.role_title
            let cell4 = document.createElement("td")
            cell4.innerHTML = employee.role.role_title
            row.appendChild(cell4)


            //append the row (tr) to the table body (tbody)
            //a new row will be appended FOR EVERY EMPLOYEE that got returned in the fetch
            document.getElementById("employeeBody").appendChild(row)

        }

    } else {
        alert("something went wrong! make sure your Java is running")
    } 
} //end of getEmployees()

//This function will send the user's login credentials as JSON to the backend-------------------------------
async function loginFunction(){

    //gather the user's credentials from the login inputs
    //when the login button is clicked, these variables get populated
    let user = document.getElementById("username").value
    let pass = document.getElementById("password").value

    //we want to send this login data as JSON, so we need a JS object first
    let userCreds = {
        username: user,
        password: pass
    } //the names of the variables must match our Java object (LoginDTO in this case)

    //for debugging purposes, print out userCreds
    console.log(userCreds)

    //fetch request to the server
    //this fetch has two parameters: the URL, and a configuration object to configure our HTTP Request
    //In this config object, we're going to manipulate attributes to make sure we send a POST with a body
    let response = await fetch(url + "/login", {
        method: "POST", //send a POST request (would be a GET if we didn't specify)
        body: JSON.stringify(userCreds), //turning our userCreds object into JSON to send to the server
        credentials: "include"
        //this last line will ensure a cookie gets captured (so that we can use sessions)
        //future fetches after login will require this "include" variable************************
    })

    //log the response status code, good for debugging
    console.log(response.status) 

    //control flow based on successful login
    if(response.status === 202) {

        //convert the incoming User data from JSON to JS (remember login returns a User)
        let data = await response.json();

        //wipe our login row and welcome the user
        document.getElementById("loginRow").innerText = "Welcome " + data.username;

        //THIS IS PROBABLY WWHERE YOUR REDIRECT WOULD GO IF USING MULTIPLE HTML PAGES
        //check the users role id and use some control flow to determine what page gets rendered
    } else {
        //the header will change if the login fails
        document.getElementById("welcomeHead").innerText="Login Failed! Try Again...";
        document.getElementById("welcomeHead").style.color = "red";
    }
}
//Ben recommends to have one login page, and based on the user's user_role_id, switch pages
//so if user_role_id is equal to "employee", send them to the employees page
//and then the same kind of logic for managers.
//You'll have to google how to switch pages from a JS function. Easier than it sounds!!

//This would be 3 HTML total and 3 JS files total

//This function will take in user input to update a Role's salary-------------------------------
async function updateSalary(){

    //gather the user inputs for role title and role salary
    //remember, the values in parenthesis are the IDs of the input elements in our HTML
    let title = document.getElementById("roleTitle").value
    let salary = document.getElementById("salary").value

    //fetch request to update role salary (PUT)
    //it will take the role title as a path param, and it will take the new salary as the body
    let response = await fetch(url + "/roles/" + title, {
        method:"PUT", //send a PUT request (check the endpoint handler in the launcher, it takes a PUT to /roles/:title)
        body: salary //no need to turn this into JSON, it's just one number
    })
    //this fetch has two parameters: the URL, and a {configuration object} to configure our HTTP Request
    //In this config object, we're going to manipulate attributes to make sure we send a PUT with a body

    //I want some control flow on the status code to change the HTML appropriately
    if(response.status === 202){ //if the update was successful...
        //tell the user the update was successful, along with the pertinent details
        document.getElementById("updateHeader").innerText = "Salary for " + title + " updated to: " + salary
    } else {
        document.getElementById("updateHeader").innerText = "Update failed! Perhaps you typed the title wrong?"
    }

}