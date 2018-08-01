import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
declare var jquery:any;
declare var $ :any;
declare var M:any;

@Component({
  selector: 'ganador',
  templateUrl: './ganador.component.html',
  styleUrls: ['./ganador.component.css']
})

export class GanadorComponent {
    
    public winner:string = "";
    public teams = [];
    public team1:any = "";
    public team2:any = "";
    private baseUrl:string = "http://localhost:5100";


    constructor(private http:Http){   
    }

    ngOnInit() {
        M.AutoInit();
        this.getTeams();
    }


    public logout():void {
        location.assign("/");
    }

    public predict():void {
        let p1 = this.teams[this.team1].score;
        let p2 = this.teams[this.team2].score;
        if(p1 > p2){
            this.winner = this.teams[this.team1].team;
        } else if( p1 < p2){
            this.winner = this.teams[this.team2].team;
        } else {
            this.winner = "Draw";
        }
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