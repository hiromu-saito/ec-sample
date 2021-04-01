const searchUrl = "http://localhost:18081/item?"

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
  async setResultsAction({commit},where){
    const response = await fetch(searchUrl+ new URLSearchParams(where))
    .then(response => response.json())
    commit('setResults',response)
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