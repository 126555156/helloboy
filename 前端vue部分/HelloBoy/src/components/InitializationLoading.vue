<template>
    <div class="InitializationLoading" v-if="show">
        <div class="init—title">进入系统中...</div>
        <Progress :percent="percent" :stroke-width="35" class="init-percent">
            <Icon type="checkmark-circled" v-show="!show"></Icon>
            <span v-show="!show">成功</span>
        </Progress>
    </div>
</template>
<script>
import Mixin from "../Mixin/mixinimg";
export default {
  mixins: [Mixin],
  data() {
    return {
      percent: 0,
      show: true
    };
  },
  methods: {},
  mounted() {
     this.show.inner.print 
    // var interval = setInterval(() => {
    //   this.percent++;
    //   if (this.percent >= 100) {
    //     clearInterval(interval);
    //     this.show = false;
    //   }
    // }, 100);
  }
};
</script>

<style lang="scss">
.InitializationLoading {
  position: absolute;
  height: 100%;
  width: 100%;
  background-color: rgba(22, 43, 66, 0.87);
  z-index: 500;
}
.InitializationLoading .init-percent {
  position: relative;
  width: 40%;
  top: 40%;
}
.init—title {
  width: 100%;
  position: relative;
  top: 37%;
  font-size: 25px;
  color: white;
  float: left;
}
</style>
