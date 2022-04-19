import { Component } from '@angular/core';
import { UserServiceService } from './user-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  users: any;

  constructor(private userService: UserServiceService){
    userService.findAll().subscribe((data) => {
      console.warn('data',data);
      this.users=data;
    });
  }
  
  getUserFormData(data:any){
    this.userService.save(data).subscribe((result)=>{
      console.warn(result);
    });
    
  }
}
