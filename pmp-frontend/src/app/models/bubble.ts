//
  // Constructor for our Snowflake object
  //
  class Bubble {
    element: HTMLElement;
    speed: number;
    xPos: number;
    yPos: number;
    scale: number;
    counter: number;
    sign: number;

    browserHeight: number;

    constructor(element, speed, xPos, yPos) {
      // set initial snowflake properties
      this.element = element;
      this.speed = speed;
      this.xPos = xPos;
      this.yPos = yPos;
      this.scale = 1;

      // declare variables used for snowflake's motion
      this.counter = 0;
      this.sign = Math.random() < 0.5 ? 1 : -1;

      // setting an initial opacity and size for our snowflake
      this.element.style.opacity = String((0.1 + Math.random()) / 3);
    }

    // The function responsible for actually moving our snowflake
    update(delta) {
      // using some trigonometry to determine our x and y position
      this.counter += (this.speed / 5000) * delta;
      this.xPos += (this.sign * delta * this.speed * Math.cos(this.counter)) / 40;
      this.yPos += Math.sin(this.counter) / 40 + (this.speed * delta) / 30;
      this.scale = 0.5 + Math.abs((10 * Math.cos(this.counter)) / 20);

      // setting our snowflake's position
      this.setTransform(
        Math.round(this.xPos),
        Math.round(this.yPos),
        this.scale,
        this.element
      );

      // if snowflake goes below the browser window, move it back to the top
      if (this.yPos > this.browserHeight) {
        this.yPos = -50;
      }
    }

    //
  // A performant way to set your snowflake's position and size
  //
  public setTransform(xPos, yPos, scale, el) {
    el.style.transform = `translate3d(${xPos}px, ${yPos}px, 0) scale(${scale}, ${scale})`;
  }

  
  }