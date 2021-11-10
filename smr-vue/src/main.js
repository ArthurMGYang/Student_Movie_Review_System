import Vue from 'vue'
import App from './App'
import router from './router'

const axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
Vue.prototype.$axios = axios
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
