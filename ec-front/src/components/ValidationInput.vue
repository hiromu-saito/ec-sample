<template>
    <validation-provider
      :name="name"
      :rules="rules"
      v-slot="{errors}">
      <input
        v-model="inputValue"
        :id="name"
        :type="inputType"
        :name="name"
        :placeholder="placeholder"/>
      <span class="error" >{{errors[0]}}</span>
    </validation-provider>
</template>

<script>
export default {
  name:  'ValidationInput',

  props:{
    rules:{
      type:String,
      required:true
    },
    inputType:{
      type:String,
      required:true
    },
    name:{
      type:String,
      required:true
    },
    placeholder:{
      type:String,
      required:false
    },
    value:{
      type:String
    }
  },
  computed:{
    inputValue:{
      get(){
        return this.$props.value
      },
      set(value){
        this.$emit('update:value',value)
      }
    },
}
}
</script>

<style scoped>
.error{
  color: red;
  padding-left: 16px;
}

</style>