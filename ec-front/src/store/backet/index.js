
const state ={
  backetItems:[]
}

const mutations = {
  addItem(state,payload){
    payload.forEach(addItem => {
      const index = state.backetItems.findIndex(backetItem =>{
        return backetItem.itemCode === addItem.itemCode
      })
      if(index === -1){
        addItem.count = parseInt(addItem.count,10)
        state.backetItems.push(addItem)
      }else{
        state.backetItems[index].count += parseInt(addItem.count,10)
      }
    })
  },
  removeItems(state,payload){
    payload.forEach(removeItemCode =>{
      const index = state.backetItems.findIndex(backetItem =>{
        return removeItemCode === backetItem.itemCode
      })
      if (index !== -1){
        state.backetItems.splice(index,1)
      }
    })
  },
  removeAllItem(state){
    state.backetItems = []
  },
  updateBacket(state,payload){
    state.backetItems  = payload
  }
}
const actions = {
  addItemAction({commit},payload){
    commit('addItem',payload)
  },
  removeItemsAction({commit},payload){
    commit('removeItems',payload)
  },
  removeAllItemAction({commit}){
    commit('removeAllItem')
  },
  updateBacketAction({commit},payload){
    commit('updateBacket',payload)
  }
}

const getters ={
  subtotal(state){
    let subtotal = 0;
    state.backetItems.forEach(backetItem => {
      subtotal += parseInt(backetItem.unitPrice) * backetItem.count
    });
    return subtotal
  },

  tax(state,getters) {
    return getters.subtotal * 0.1
  },

  total(state,getters){
    return getters.subtotal + getters.tax
  },

  backetItems(state){
    return state.backetItems
  }
}

export default{
  namespaced:true,
  state,
  mutations,
  actions,
  getters
}