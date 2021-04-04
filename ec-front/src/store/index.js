import Vue from 'vue'
import Vuex from 'vuex'
import search from './search'
import backet from './backet'
import auth from './auth'
import createPersistedState  from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    search,
    backet,
    auth
  },
  getters:{
  },
  plugins: [createPersistedState({storage: window.sessionStorage})]
})
