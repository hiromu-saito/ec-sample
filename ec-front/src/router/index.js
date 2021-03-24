import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Signup from '../views/Signup.vue'
import Search from '../views/Search.vue'
import Backet from '../views/Backet.vue'
import SignupSuccess from '../views/SignupSuccess'
import MemberInfo from '../views/MemberInfo'
import MemberModify from '../views/MemberModify'
import MemberDelete from '../views/MemberDelete'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
  {
    path:'/member_info',
    name:'MemberInfo',
    component:MemberInfo
  },
  {
    path:'/member_modify',
    name:'MemberModify',
    component:MemberModify
  },
  {
    path:'/member_delete',
    name:'MemberDelete',
    component:MemberDelete
  },
  {
    path: '/signup_success/:id',
    name: 'SignupSuccess',
    component: SignupSuccess
  },
  {
    path: '/search',
    name: 'Search',
    component: Search
  },
  {
    path: '/backet',
    name: 'Backet',
    component: Backet
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
