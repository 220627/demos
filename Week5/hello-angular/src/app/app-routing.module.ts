import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnotherComponentComponent } from './components/another-component/another-component.component';

//The more dyanamic way to display components is through ROUTING
//we use routing to move components in and out of the user's view (the webpage) depending on URL
//For this basic demo, we will have to append the URL ourselves
//But in the future I'll show us how to use webpage logic to change the URL
const routes: Routes = [

  //every valid route needs a path (the URI), and a component associated with it
  {
    path:"another", //path is the endpoint to reach this component
    component: AnotherComponentComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
