import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})

let bubbles = [];

// Global variables to store our browser's window size
let browserWidth;
let browserHeight;

// Specify the number of snowflakes you want visible
let numberOfSnowflakes = 50;

// Flag to reset the position of the snowflakes
let resetPosition = false;

// Handle accessibility
let enableAnimations = false;
let reduceMotionQuery = matchMedia("(prefers-reduced-motion)");

let frames_per_second = 60;
let frame_interval = 1000 / frames_per_second;

let previousTime = performance.now();
let delta = 1;

export class MainComponent implements OnInit{

  ngOnInit(): void {
    this.setAccessibilityState();
    reduceMotionQuery.addListener(this.setAccessibilityState);
    this.setup();
  }

  // Handle animation accessibility preferences
  public setAccessibilityState() {
    if (reduceMotionQuery.matches) {
      enableAnimations = false;
    } else {
      enableAnimations = true;
    }
  }

  //
  // It all starts here...
  //
  public setup() {
    if (enableAnimations) {
      window.addEventListener("DOMContentLoaded", this.generateSnowflakes, false);
      window.addEventListener("resize", setResetFlag, false);
    }
  }

  //
  // The function responsible for creating the snowflake
  //
  public generateSnowflakes() {
    // get our snowflake element from the DOM and store it
    let originalSnowflake = document.querySelector(".bubble");

    // access our snowflake element's parent container
    let snowflakeContainer = originalSnowflake.parentNode;
    snowflakeContainer.style.display = "block";

    // get our browser's size
    browserWidth = document.documentElement.clientWidth;
    browserHeight = document.documentElement.clientHeight;

    // create each individual snowflake
    for (let i = 0; i < numberOfSnowflakes; i++) {
      // clone our original snowflake and add it to snowflakeContainer
      let snowflakeClone = originalSnowflake.cloneNode(true);
      snowflakeContainer.appendChild(snowflakeClone);

      // set our snowflake's initial position and related properties
      let initialXPos = getPosition(50, browserWidth);
      let initialYPos = getPosition(50, browserHeight);
      let speed = (5 + Math.random() * 40) * delta;

      // create our Snowflake object
      let snowflakeObject = new Snowflake(
        snowflakeClone,
        speed,
        initialXPos,
        initialYPos
      );
      snowflakes.push(snowflakeObject);
    }

    // remove the original snowflake because we no longer need it visible
    snowflakeContainer.removeChild(originalSnowflake);

    requestAnimationFrame(this.moveSnowflakes);
  }

  //
  // Responsible for moving each snowflake by calling its update function
  //
  
 

  public moveSnowflakes(currentTime) {
    delta = (currentTime - previousTime) / frame_interval;

    if (enableAnimations) {
      for (let i = 0; i < bubbles.length; i++) {
        let snowflake = bubbles[i];
        snowflake.update(delta);
      }
    }

    previousTime = currentTime;

    // Reset the position of all the snowflakes to a new value
    if (resetPosition) {
      browserWidth = document.documentElement.clientWidth;
      browserHeight = document.documentElement.clientHeight;

      for (let i = 0; i < bubbles.length; i++) {
        let snowflake = bubbles[i];

        snowflake.xPos = getPosition(50, browserWidth);
        snowflake.yPos = getPosition(50, browserHeight);
      }

      resetPosition = false;
    }

    requestAnimationFrame(this.moveSnowflakes);
  }


}
