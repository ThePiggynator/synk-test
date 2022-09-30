import { createApp } from 'vue'
// import App from './App.vue'
import {router} from './routes/index.js'
import App33 from './App33.vue'

// import 'bootstrap/dist/css/bootstrap.css'
// import 'bootstrap-vue/dist/bootstrap-vue.css'

// createApp(App).mount('#app')
createApp(App33).use(router).mount('#app')

