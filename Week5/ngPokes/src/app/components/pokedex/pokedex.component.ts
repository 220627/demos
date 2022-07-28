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

  ngOnInit(): void {
  }

}
