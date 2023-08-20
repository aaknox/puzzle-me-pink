import { Component, OnInit } from '@angular/core';
import { Meta,Title } from '@angular/platform-browser';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})

export class MainComponent implements OnInit{

  ngOnInit(): void {
    
  }

  constructor(private meta: Meta,private title: Title){
    this.meta.addTags([
      {
        name: "description", 
        content: "Landing page of Puzzle Me Pink app"
      },
      {
        name: "author", 
        content: "Azhya Knox"
      },
      {
        name: "keywords", 
        content: "crossword puzzles, crossword, free crossword puzzles, free online crossword puzzles, crossword competition, highly competitive crossword, competitive video gaming crossword, fair competition crossword, multiplayer games, online multiplayer games, crossword puzzle multiplayer"
      }
    ]);

    this.setTitle('PMP | Home Page');
  }

  public setTitle( newTitle: string) {
    this.title.setTitle( newTitle );
  }
}
