//You can think of the models folder in Angular like the models package Java
//It holds Classes that we intend to make object of
export class Pokemon {

    //this constructor will initialize the Pokemon's variables when we get it from the API
    constructor(
        public name: String,
        public types: any,
        public sprites: any
    ){}

}