import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {
	
// Importing Images
PImage sonic_spritesheet;
PImage sonic_runningsheet;
PImage[] sonic_right;

// Declaring Variables
int intSonic_right = 8;
int intSonic_frameWidth = 40;
int intSonic_frameHeight = 40;
int intSonicX = 20;
int intSonicY = 80;
boolean dPressed = false;
boolean aPressed = false;

public void settings() {
// put your size call here
  size(400, 400);

}

public void setup() {
  background(210, 255, 173);

  // Load Sonic Runnning Right Spritesheet
  sonic_spritesheet = loadImage("Sonicsheet.png");
  sonic_runningsheet = sonic_spritesheet.get(2,267, intSonic_frameWidth*intSonic_right, intSonic_frameHeight );

  // load the sonic Running Right from the spritesheet
  sonic_right = new PImage[intSonic_right];
  for(int frameNum = 0; frameNum < intSonic_right; frameNum++ ){
    System.out.println("load frames");
    sonic_right[frameNum] = sonic_runningsheet.get(intSonic_frameWidth*frameNum, 0, intSonic_frameWidth, intSonic_frameHeight );
  }

}


public void draw() {
  // Background
  background(0, 0, 0);

  // Draw Sonic to Screen
   

  if(intSonicX > width){
    intSonicX = 0 - intSonic_frameWidth;
    }


  
    // Movement for Sonic
  if (dPressed) {
    intSonicX += 2;
    image(sonic_right[(frameCount/3)%intSonic_right], intSonicX, intSonicY);
   } 

  if (aPressed) {
    intSonicX -= 2;
  }

  if (intSonicX == 0) {

  }
   
}

public void keyPressed() {
if (key == 'd') {
  dPressed = true;
}

if (key == 'a') {
  aPressed = true;
}
}

public void keyReleased() {
  if (key == 'd') {
    dPressed = false;
  }
  
  if (key == 'a') {
    aPressed = false;
  }

}
}
