import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import {MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit{
  constructor(private userService:UserService,private snackBar: MatSnackBar ){}
  ngOnInit(): void {
      
  }

  public user={
    userName: '',
    password: '',
    firstName:'',
    lastName:'',
    email:'',
    profile:'',
  };

  formSubmit(){
    console.log(this.user);
    if(this.user.userName=='' || this.user.userName==null){
      this.snackBar.open("User not null",'X',{
        duration:3000,
        verticalPosition:'top',
      });
      return;
    }
    if(this.user.password=='' || this.user.password==null){
      this.snackBar.open("Password not null",'X',{
        duration:3000,
        verticalPosition:'top',
      });
    }
    if(this.user.firstName=='' || this.user.firstName==null){
      this.snackBar.open("First name not null",'X',{
        duration:3000,
        verticalPosition:'top',
      });
    }
    if(this.user.lastName=='' || this.user.lastName==null){
      this.snackBar.open("Last name not null",'X',{
        duration:3000,
        verticalPosition:'top',
      });
    }
    if(this.user.email=='' || this.user.email==null){
      this.snackBar.open("Email not null",'X',{
        duration:3000,
        verticalPosition:'top',
      });
    }

    this.userService.addUser(this.user).subscribe(
      (data:any) => {
        console.log(data);
        Swal.fire("Success","User is registered with id "+data.id,"success");
      },
      (error:any) => {
        console.log(error);
        Swal.fire("Failed","Registration failed: "+error.error,"error");
      }
    );
  }

}
