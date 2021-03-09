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

const getters ={
  subtotal(state){
    let subtotal = 0;
    state.backetItems.forEach(backetItem => {
      subtotal += parseInt(backetItem.price)
    });
    return subtotal
  },

  tax(state,getters) {
    return getters.subtotal * 0.1
  },

  total(state,getters){
    return getters.subtotal + getters.tax
  }
}

export default{
  namespaced:true,
  state,
  mutations,
  actions,
  getters
}