const state ={
  backetItems:[]
}

const mutations = {
  // setItem(state,payload){
  //   state.results = payload
  // },
  // resetResults(state){
  //   state.results = undefined
  // }
  
  addItem(state,payload){
  console.log('addItem')
  console.log(payload)
  //  payload.forEach(addItem => {
  //    const index = state.backetItems.findIndex(backetItem =>{
  //      console.log('find')
  //      console.log('backetItem' + backetItem.code)
  //      console.log('addItem' + addItem.code)
  //      backetItem.code === addItem.code
  //     })
  //     console.log(index)
  //    if(index === -1){
  //      console.log('else')
  //      state.backetItems.push(addItem)
  //   }else{
  //       console.log('if')
  //       state.backetItems[index].count += addItem.count
  //    }
  //  })
  state.backetItems = state.backetItems.concat(payload)
}
}
const actions = {
  // async setResultsAction({commit},){
  //   const res = await fetch(searchUrl)
  //   .then(response => response.json())
  //   commit('setResults',res)
  // },
  // resetResultsAction({commit}){
  //   commit('resetResults')
  // }
  addItemAction({commit},payload){
    commit('addItem',payload)
  }
}

export default{
  namespaced:true,
  state,
  mutations,
  actions,
}