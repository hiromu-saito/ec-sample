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
      <p style="color:red">{{errors[0]}}</p>
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
      required:true
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

<style>

</style>