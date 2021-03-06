const state ={
  backetItems:[]
}

const mutations = {
  addItem(state,payload){
    payload.forEach(addItem => {
      const index = state.backetItems.findIndex(backetItem =>{
        return backetItem.code === addItem.code
      })
      if(index === -1){
        addItem.count = parseInt(addItem.count,10)
        state.backetItems.push(addItem)
      }else{
        state.backetItems[index].count += parseInt(addItem.count,10)
      }
    })
  },
  removeAllItem(state){
    state.backetItems = []
  }
}
const actions = {
  addItemAction({commit},payload){
    commit('addItem',payload)
  },
  removeAllItemAction({commit}){
    commit('removeAllItem')
  }
}

export default{
  namespaced:true,
  state,
  mutations,
  actions,
}