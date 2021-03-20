<template>
  <div class="login">
    <router-link to="/signup">新規会員登録の方はこちら</router-link>
    <validation-observer
      v-slot="{invalid}"
      tag="form"
      >
      <div>
          <span class="input_item">会員NO</span>
          <validation-input
            inputType="text"
            name="会員番号"
            placeholder=""
            rules="required|numalpha"
            :value.sync=memNo
          />
          <br>
          <span class="input_item">パスワード</span>
          <validation-input
            inputType="password"
            name="パスワード"
            placeholder=""
            rules="required|numalpha|max:8"
            :value.sync=pass
          />
      </div>
      <p>
        <button @click.prevent="login" :disabled=invalid>ログイン</button>
        <button @click.prevent="clear">クリア</button>
      </p>
    </validation-observer>
    <span
      v-if="isErr"
      style="color:red">
        ログインに失敗しました
    </span>
  </div>
</template>

<script>
import ValidationInput from '../components/ValidationInput'
import  { mapActions } from 'vuex'

export default {
  name: "Login",
  components:{
    ValidationInput
  },
  data(){
    return{
      memNo:'',
      pass:'',
      isErr:false
    }
  },
  methods:{
    ...mapActions('auth',['nameSaveAction']),
    clear(){
      this.memNo =''
      this.pass =''
      this.$children[1].reset()
    },
    login(){
      //テスト
      console.log("testlogon")
      const mem = {
        name :"test"
      }
      this.nameSaveAction(mem)
      //ログインAPIをたたく
      // fetch('http://localhost:18081/auth?'+new URLSearchParams({
      //   memNo:this.memNo,
      //   pass:this.pass
      // }))
      //   .then(response =>{
      //     if (response.ok){
      //       return response.json()
      //     }else{
      //       this.isErr = true
      //       this.clear();
      //       return Promise.reject("login failure")
      //     }
      //   })
      //   .then(response =>{
      //     console.log(response)
      //     this.nameSaveAction(response)
      //   });
      
    }
  }
};
</script>

<style scoped>
.login{
  margin: 60px  0 0 30px;
}
.input_item{
  display:inline-block;
  width: 100px;
}
</style>