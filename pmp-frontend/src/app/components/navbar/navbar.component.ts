import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  isCollapsed = true; 
  currentUserName: string | undefined;

  constructor(private router: Router){}

  public closeMenuEvent() {
    console.log('event triggered');
    this.isCollapsed = !this.isCollapsed;
  }

  logout(event: any){
    localStorage.clear();
    this.router.navigateByUrl("/login");
  }

}
