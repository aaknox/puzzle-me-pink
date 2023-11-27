import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { gsap, ScrollTrigger } from "gsap/all";
import { TimelineMax } from 'gsap';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
  menu = new TimelineMax({paused:true, reversed:true});
  
  isCollapsed = true; 
  currentUserName: string | undefined;
  
  constructor(private router: Router){}
  
  ngOnInit(){
    gsap.registerPlugin(ScrollTrigger)
    this.createMenuAnim()
  }

  createMenuAnim(){
    this.menu.to("#topLine", .5, {rotation:'30', ease:"Expo.easeInOut"},0)
    this.menu.to("#midLine", .5, {opacity:'0', ease:"Expo.easeInOut"},0)
    this.menu.to("#botLine", .5, {rotation:'-30', ease:"Expo.easeInOut"},0)
  }
  
  menuClick() {
    console.log('menu button clicked with gsap')
    this.menu.reversed() ? this.menu.play() : this.menu.reverse();	
    //for the collapisble content
    this.isCollapsed = !this.isCollapsed
    return console.log('clicked');
   }

  public closeMenuEvent() {
    console.log('event triggered');
    this.isCollapsed = !this.isCollapsed;
  }

  logout(event: any){
    localStorage.clear();
    this.router.navigateByUrl("/login");
  }

}
