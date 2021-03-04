const searchUrl = "http://localhost:3000/search"

const state ={
  results:[]
}

const mutations = {
  setResults(state,payload){
    state.results = payload
  },
  resetResults(state){
    state.results = undefined
  }
}
const actions = {
  async setResultsAction({commit},){
    const res = await fetch(searchUrl)
    .then(response => response.json())
    commit('setResults',res)
  },
  resetResultsAction({commit}){
    commit('resetResults')
  }
}

export default{
  namespaced:true,
  state,
  mutations,
  actions,
}