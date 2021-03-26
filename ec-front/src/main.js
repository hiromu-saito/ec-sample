import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import {ValidationProvider,ValidationObserver} from './common/validate'
import ValidationInput from './components/ValidationInput';

Vue.component('validation-provider', ValidationProvider)
Vue.component('validation-observer', ValidationObserver)

Vue.component('validation-input',ValidationInput)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
