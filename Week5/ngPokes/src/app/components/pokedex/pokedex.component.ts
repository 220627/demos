import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {

  //this variable gets filled by the user input in the pokedex html
  public input:number = 0;

  //this Pokemon object will get filled with Http Response data, and rendered on the component's HTML
  public pokemon:Pokemon = {
    name:"",
    types:"",
    sprites:""
  }

  //we need to INJECT the pokemon service so that we have access to its functions/variables
  constructor(private ps:PokemonService) { }

  //This is the function that gets our Pokemon object using a function from the Pokemon Service
  //In order to get data from the Observable returned by the Service, we need to SUBSCRIBE
  getPoke(){

    //this.input is the variable that gets filled by the user on the webpage
    this.ps.getPokemonFromApi(this.input).subscribe(

      //assign the body of the Http Response to our pokemon variable
      (data:any) => {
        this.pokemon = data.body; //get the data, put it in our pokemon variable
        console.log(this.pokemon); //print out our pokemon, helpful for debugs.
      }

    )

  }

  ngOnInit(): void {
  }

}
