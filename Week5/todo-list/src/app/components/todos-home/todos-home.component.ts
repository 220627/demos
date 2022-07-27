import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  //a variable that determines whether the todo cards are hidden or not
  hiddenToggle:boolean = true;

  //a variable that determines whether the nameDiv is hidden or not
  nameDivToggle:boolean = false;

  //a variable that stores the name inserted by the user
  name:String="";

  //4 todo objects that we will render onto our webpage
  todo1 = {
    id: 1,
    task: "wake up",
    status: "Incomplete"
  }

  todo2 = {
    id: 2,
    task: "grab a brush",
    status: "Incomplete"
  }

  todo3 = {
    id: 3,
    task: "put a little makeup",
    status: "Incomplete"
  }

  todo4 = {
    id: 4,
    task: "something else?",
    status: "Incomplete"
  }

  //An Array filled with the above todo objects
  //we're going to call from this in our HTML to render our todo list
  todosArray = [this.todo1, this.todo2, this.todo3, this.todo4]


  //function to toggle todo list visibility
  showTodoList(){
    this.hiddenToggle = !this.hiddenToggle 
    //setting the boolean to the opposite of its current value
  }

  //function to toggle todo list status
  completeTask(id:number){
    this.todosArray[id - 1].status = "complete"
    //why - 1? Arrays are zero indexed. If we didn't do this, the card after the target would update.
  }

  //function to hide to nameDiv after the user submits their name
  submitName(){
    this.nameDivToggle = true;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
