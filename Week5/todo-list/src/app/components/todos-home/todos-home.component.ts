import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  //a variable that determines whether the todo cards are hidden or not
  hiddenToggle:boolean = true;

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

  //An Array filled with the above todo objects
  //we're going to call from this in our HTML to render our todo list
  todosArray = [this.todo1, this.todo2]


  //function to toggle todo list visibility
  showTodoList(){
    this.hiddenToggle = !this.hiddenToggle 
    //setting the boolean to the opposite of its current value
  }



  constructor() { }

  ngOnInit(): void {
  }

}
