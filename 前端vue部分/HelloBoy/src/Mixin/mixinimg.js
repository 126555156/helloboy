import loginimg from "@/assets/login.jpg"
import logo2018 from "@/assets/2018logo.png"
import m2018 from "@/assets/2018.jpg"
import helloboyhome1 from "@/assets/helloboyhome1.jpg"
import Scenery2 from "@/assets/Scenery2.jpg"
import shutterstock from "@/assets/shutterstock.jpg"
var Mixin = {
    data() {
        return {
            img: {
                loginimg: loginimg,
                logo2018: logo2018,
                m2018:m2018,
                helloboyhome1:helloboyhome1,
                Scenery2:Scenery2,
                shutterstock:shutterstock,
            }
        }
    },
    methods: {

    },
    computed: {

    },
    mounted() {
        console.log(Object.keys(this.img).length)
        for (var i in this.img) {
            console.log(this.img[i])
            var newImg = new Image();
            newImg.src = this.img[i];
            newImg.onload = () => {
                // 图片加载成功后把地址给原来的img
                console.log("加载成了");
                this.percent+=100/Object.keys(this.img).length
                if(this.percent>=100)this.show=false
            };
            newImg.onerror = () => {
                console.log("加载失败");
            }
        }
    }
}
export default Mixin;