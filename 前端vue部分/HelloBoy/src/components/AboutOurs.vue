<template>
  <div class="AboutOurs">
    <!-- <h1> 嘿！这个页面还没做别看了</h1>
     <vue-pull-refresh :on-refresh="onRefresh">
     <h1> 嘿！这个页面还没做别看了</h1>
     <h1> 嘿！这个页面还没做别看了</h1>
 
     </vue-pull-refresh> -->
    <pull-to :top-load-method="refresh">
      <h1> 嘿！这个页面还没做别看了</h1>
      <h1> 嘿！这个页面还没做别看了</h1>
      <h1> 嘿！这个页面还没做别看了</h1>
      <h1> 嘿！这个页面还没做别看了</h1>
      <h1> 嘿！这个页面还没做别看了</h1>
      <h1> 嘿！这个页面还没做别看了</h1>
    </pull-to>
    <vue-draggable-resizable :w="100" :h="100" v-on:dragging="onDrag" :parent="true" :resizable = "false">
      <p>Hello! I'm a flexible component. You can drag me around and you can resize me.<br> X: {{ x }} / Y: {{ y }} - Width: {{ width }} / Height: {{ height }}</p>
    </vue-draggable-resizable>
  </div>
</template>
<script>
import VuePullRefresh from "vue-pull-refresh";
import PullTo from "vue-pull-to";
// import { fetchDataList } from "api";
import VueDraggableResizable from "vue-draggable-resizable";
export default {
  data() {
    return {
      dataList: [],
      width: 0,
      height: 0,
      x: 0,
      y: 0
    };
  },
  methods: {
    onRefresh: function() {
      //下拉组件只有在手机有效
      console.log(1111);
      return new Promise(function(resolve, reject) {
        console.log(resolve, reject);
        setTimeout(function() {
          resolve();
        }, 1000);
      });
    },
    refresh(loaded) {
      // fetchDataList().then(res => {
      //   this.dataList = res.data.dataList;
      //   loaded("done");
      // });
    },
    onResize: function(x, y, width, height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    },
    onDrag: function(x, y) {
      this.x = x;
      this.y = y;
    }
  },
  components: {
    VuePullRefresh,
    PullTo,
    VueDraggableResizable
  }
};
</script>
<style lang="scss">
.AboutOurs {
  height: 100%;
  width: 100%;
  overflow: auto;
}
</style>
