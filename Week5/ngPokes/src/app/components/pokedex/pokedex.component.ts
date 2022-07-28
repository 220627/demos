import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {

  //this variable gets filled by the user input in the pokedex html
  public input:number = 0;

  constructor() { }

  //This is the function that gets our Pokemon object using a functino from the Pokemon Service
  //In order to get data from the Observable returned by the Service, we need to SUBSCRIBE
  getPoke(){
    
  }

  ngOnInit(): void {
  }

}
