<template>
  <div class="HelloBoyHome">
    <Carousel v-model="value1" :autoplay="setting.autoplay" :autoplay-speed="setting.autoplaySpeed" :dots="setting.dots" :radius-dot="setting.radiusDot" :trigger="setting.trigger" :arrow="setting.arrow">
      <CarouselItem>
        <div class="carousel1"></div>
      </CarouselItem>
      <CarouselItem>
        <div class="carousel2"></div>
      </CarouselItem>
      <CarouselItem>
        <div class="carousel3"></div>
      </CarouselItem>
    </Carousel>
    <div class="HelloBoyHome-title">
      私人网站测试模版
    </div>
    <div class="HelloBoyHome-title-e">Private web site test template</div>
    <div class="HelloBoyHome-Timeline">
      <Timeline >
        <TimelineItem color="green">
             <!-- <Icon type="trophy" slot="dot"></Icon> -->
                <p class="time">2018年</p>
          <p class="content">测试模版啦啦啦</p>
        </TimelineItem>
        <TimelineItem>
          <p class="time">1984年</p>
          <p class="content">发布 Macintosh</p>
        </TimelineItem>
        <TimelineItem>
          <p class="time">2007年</p>
          <p class="content">发布 iPhone</p>
        </TimelineItem>
        <TimelineItem>
          <p class="time">2010年</p>
          <p class="content">发布 iPad</p>
        </TimelineItem>
        <TimelineItem>
          <p class="time">2011年10月5日</p>
          <p class="content">史蒂夫·乔布斯去世</p>
        </TimelineItem>
      </Timeline>
    </div>
    <div class="HelloBoyHome-add">真不知道加什么，就空着吧</div>
    <div class="HelloBoyHome-footer">
      <div class="HelloBoyHome-footer-text">私人网站测试模版，需要啥请联系程序猿</div>
      <div>©2018|版权归黄炜雄所有</div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      value1: 0,
      setting: {
        autoplay: true,
        autoplaySpeed: 5000,
        dots: "outside",
        radiusDot: true,
        trigger: "hover",
        arrow: "hover"
      }
    };
  }
};
</script>
<style lang="scss">
.HelloBoyHome {
  height: 650px;
  width: 100%;
}
.HelloBoyHome .carousel1 {
  height: 650px;
  background: url(../assets/2018.jpg);
  background-size: 100% 100%;
}
.HelloBoyHome .carousel2 {
  height: 650px;
  background: url(../assets/helloboyhome1.jpg);
  background-size:cover;
}
.HelloBoyHome .carousel3 {
  height: 650px;
  background: url(../assets/Scenery2.jpg);
  background-size: 100% 100%;
}
.HelloBoyHome-title {
  height: 100px;
  line-height: 150px;
  font-size: 25px;
  font-weight: 800;
}
.HelloBoyHome-title-e {
  height: 50px;
  // line-height: 50px;
  font-size: 13px;
  font-weight: 600;
}
.time {
  font-size: 14px;
  font-weight: bold;
}
.content {
  padding-left: 5px;
}
.HelloBoyHome-Timeline {
  color: rgb(197, 121, 86);
  margin-top: 30px;
  position: relative;
padding: 70px 30%;
// height: 500px;
  background: url(../assets/shutterstock.jpg);
  background-size: cover;
  // margin-bottom: 20px;
}
.HelloBoyHome-footer{
  height: 300px;
  background: rgba(0, 0, 0, 0.842)
}
.HelloBoyHome-add{
    height: 250px;
  line-height: 250px;
    // color: #fff;
    font-size: 25px;
  font-weight: 800;
}
.HelloBoyHome-footer-text{
  color: #fff;
    font-size: 25px;
  font-weight: 800;
  height: 250px;
  line-height: 250px
}
</style>
