import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private _instMessage: String;
  private _message: String;
  private _postMessage: String;

  constructor() {
    this._instMessage = "Instruções";
    this._message = "Mande suas instruções adicionando-as ao final do diretorio: localhost:8080/rest/mars/";
    this._postMessage = "Utilize o metodo POST";
  }

  get InstMessage() {
    return this._instMessage;
  }


  get Message(): String {
    return this._message;
  }

  get PostMessage() {
    return this._postMessage;
  }

  ngOnInit(): void {
  }

}
