import Vue from 'vue'
import Vuex from 'vuex'
import search from './search'
import backet from './backet'

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
    backet
  }
})
