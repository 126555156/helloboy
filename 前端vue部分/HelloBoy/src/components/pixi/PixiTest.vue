<template>
    <div class="PixiTest" id="PixiTest"></div>
</template>
<script>
import Pixi from "./pixi.min.js";
export default {
  data() {
    return {};
  },
  mounted() {
      var app = new PIXI.Application(800, 600, {backgroundColor : 0x1099bb});
      document.getElementById("PixiTest").appendChild(app.view);
// document.body.appendChild(app.view);

// create a new Sprite from an image path
var bunny = PIXI.Sprite.fromImage('../../assets/2018logo.png')

// center the sprite's anchor point
bunny.anchor.set(0.5);

// move the sprite to the center of the screen
bunny.x = app.screen.width / 2;
bunny.y = app.screen.height / 2;

app.stage.addChild(bunny);

// Listen for animate update
app.ticker.add(function(delta) {
    // just for fun, let's rotate mr rabbit a little
    // delta is 1 if running at 100% performance
    // creates frame-independent transformation
    bunny.rotation += 0.1 * delta;
}); 
  }
};
</script>

<style lang="scss">
.PixiTest {
}
</style>
