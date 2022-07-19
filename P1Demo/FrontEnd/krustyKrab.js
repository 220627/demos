const url = "http://localhost:3000"; //putting our base URL in a variable for cleaner code below
//This will be used in fetch requests to make requests to our java server.

//add an event listener to give our buttons some functionality (DOM Selection)
document.getElementById("getEmployeeButton").onclick = getEmployees //this button will GET all employees

//getEmployees is an async function which uses a fetch request to get employees from our server
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

            //cell2

            //cell3

            //cell4

            //append the row (tr) to the table body (tbody)
            //a new row will be appended FOR EVERY EMPLOYEE that got returned in the fetch
            document.getElementById("employeeBody").appendChild(row)

        }

    } else {
        alert("something went wrong! make sure your Java is running")
    }

}