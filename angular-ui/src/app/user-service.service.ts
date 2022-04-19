import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class UserServiceService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/spring-api/users';
  }

  public findAll(){
    return this.http.get(this.usersUrl);
  }

  public save(data:any) {
    return this.http.post(this.usersUrl, data);
  }

}
