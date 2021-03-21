const state ={
  loginUser:{},
  isLogin:false,
}

const mutations = {
  nameSave(state,payload){
    state.isLogin = true
    console.log(payload)
    state.loginUser = payload
  },
  resetLoginUser(state){
    state.loginUser ={}
    state.isLogin = false
  }
}
const actions = {
  nameSaveAction({commit},payload){
    commit('nameSave',payload)
  },
  resetLoginUserAction({commit}){
    commit("resetLoginUser")
  }
}

const getters ={
  isLogin(state){
    return state.isLogin
  },
  getUser(state){
    return state.loginUser
  },
  getUserName(state){
    return state.loginUser.name
  }
}

export default{
  namespaced:true,
  state,
  mutations,
  actions,
  getters
}