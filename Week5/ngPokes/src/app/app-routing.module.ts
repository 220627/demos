import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokedexComponent } from './components/pokedex/pokedex.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

//Remember, the Routes Array is how we set up routing for components
//When we go to a certain URL path, this Array will be consulted to determine what component is rendered
const routes: Routes = [

  {
    path: "",
    component: WelcomeComponent
  },

  {
    path: "pokedex",
    component: PokedexComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
