import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodosHomeComponent } from './components/todos-home/todos-home.component';

//remember this routes array is what lets us control what component is rendered and when
//based on the URL we're on, certain components will render
const routes: Routes = [

  {
    path: "todos", //path is the URL to see the given component
    component: TodosHomeComponent //component is the component that gets rendered given a certain URL
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
