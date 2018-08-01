import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
declare var jquery:any;
declare var $ :any;
declare var M:any;

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    public username:string = "";
    public password:any = "";
    public error1:boolean = false;
    public login1:boolean = true;
    public role:string = "";
    public visible:any = "";
    public registrado:boolean = false;


    private baseUrl:string ="https://simanapi.puntosleal.com";

    constructor(private http:Http){
        this.error1 = true;
        
    }



    ngOnInit() {
        M.AutoInit();
    }

    public signUp():void {
        this.login1 = false;
    }

    public signUser():void {
        if(this.username == "" || this.username == null || this.username == undefined){
            alert("You must specify an usrname");
            return;
        }

        if(this.role == "" || this.role == null || this.role == undefined){
            alert("You must specify a role");
            return;
        }

        let temp = Math.ceil(Math.random() * 9999) * 2;
        this.visible = this.role == "p" ? temp : temp + 1;
        this.registrado = true;
    }

    public login():void{
        let ruta = (this.password % 2 == 0) ?  "/predictor" : "/editor";
        location.assign(ruta);
    }

    public aceptar():void {
        this.username = "";
        this.password = "";
        this.error1 = false;
        this.login1 = true;
        this.role = "";
        this.visible = "";
        this.registrado = false;
    }

    /*
    public login():void{
        let peticion = {
            'email': this.username,
            'contrasena': this.password
        }

        console.log(peticion);
    
        this.http.post(this.baseUrl + '/api/usu_usuarios/login_wh',peticion)
        .subscribe( response => {
          let temp = response.json();
          localStorage.setItem("token", "Bearer " + temp.token);
          location.assign("/miembros");
        },
        error => {
            console.log(error)
            this.error1 = false;
        }
        );

    }*/
}
