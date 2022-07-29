import { Component, OnInit } from '@angular/core';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  public pokeCount = this.ps.counter;

  public sprite = this.ps.pokemon.sprites.front_default

  constructor(private ps:PokemonService) { }

  ngOnInit(): void {
  }

}
