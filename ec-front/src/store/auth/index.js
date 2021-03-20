const state ={
  loginUserName:'',
  isLogin:false,
  test:[]
}

const mutations = {
  nameSave(state,payload){
    state.isLogin = true
    console.log(payload.name)
    state.loginUserName = payload.name
    state.test.push("aaa")
  }
}
const actions = {
  nameSaveAction({commit},payload){
    console.log("nameSaveAction")
    console.log(payload)
    console.log(payload.name)
    commit('nameSave',payload)
  }
}

const getters ={
  isLogin(state){
    return state.isLogin
  },
  getUserName(state){
    return state.loginUserName
  }
}

export default{
  namespaced:true,
  state,
  mutations,
  actions,
  getters
}