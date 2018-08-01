import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
declare var jquery:any;
declare var $ :any;
declare var M:any;

@Component({
  selector: 'editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})

export class EditorComponent {
  
    public teams = [];
    public player:any = "";
    public score:any = "";
    public players = [];
    public team:string = "";
    private baseUrl:string = "http://localhost:5100";


    constructor(private http:Http){   
    }

    ngOnInit() {
        M.AutoInit();
        this.getTeams();
    }


    public getScore():void {
        console.log("este es el jugador");
        this.score = this.players[this.player].score;
    }

    public logout():void {
        location.assign("/");
    }

    public edit():void {
        let peticion = {
            id: this.players[this.player].id,
            score: this.score
        };
        this.http.put(this.baseUrl + '/teams',peticion)
        .subscribe( response => {
          console.log(response);
          alert("Request Successful");
          this.players[this.player].score = this.score;
        },
        error => {
            console.log(error)
        }
        );
    }
    
    public getPlayers():void {
        this.http.get(this.baseUrl + '/teams/' + this.team)
        .subscribe( response => {
          let temp = response.json();
          console.log("estos son los jugadores");
          console.log(temp);
          this.players = temp;
          this.player= "";
          this.score = "";
        },
        error => {
            console.log(error)
        }
        );
    }

    public getTeams():void {
        this.http.get(this.baseUrl + '/teams')
        .subscribe( response => {
          let temp = response.json();
          console.log("estos son los equipos");
          console.log(temp);
          this.teams = temp;
        },
        error => {
            console.log(error)
        }
        );
    }
} 
