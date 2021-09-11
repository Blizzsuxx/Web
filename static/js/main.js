import {createApp} from "https://unpkg.com/vue@next"
import "https://unpkg.com/vue-router@next"
import ElementPlus from "https://unpkg.com/element-plus"
import  "https://unpkg.com/element-plus/lib/theme-chalk/index.css"
import App from "../app/App.vue"
import router from "./router"

createApp(App).use(ElementPlus).use(router).mount('#app')
