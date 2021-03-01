import {
  extend,
  ValidationProvider,
  ValidationObserver
} from 'vee-validate'

import {
  required,
  numeric,
  max,
  confirmed,
  // regex,
}from  'vee-validate/dist/rules';

extend('required',  {
  ...required,
  message:(fieldName)=>{
    return `${fieldName}は必須項目です`
  }
})

extend('numeric',{
  ...numeric,
  message:(fieldName)=>{
    return `${fieldName}は整数で入力してください`
  }
})

extend('max',{
  ...max,
  message:(fieldName,placeholders)=>{
    return `${fieldName}は${placeholders.length}字以下で入力してください。`
  }
})

extend('postalCode',{
  validate(value){
    return value.match(/^\d{3}-?\d{4}$/)
  },
  message:(fieldName)=>{
    return `${fieldName}はxxx-xxxxの形式で入力してください`
  }
})

extend('tel',{
  validate(value){
    return value.match(/^[0-9-]+$/)
  },
  message:(fieldName)=>{
    return `${fieldName}は半角数字とハイフンで入力してください`
  }
})

extend('passmatch',{
  ...confirmed,
  message:(fieldName,placeholders)=>{
    return `${fieldName}と${placeholders.target}は同じ値を入力してください`
  }}
)

extend('numalpha',{
  validate(value){
    return value.match(/^[a-zA-Z0-9]+$/)
  },
  message:(fieldName)=>{
    return `${fieldName}は半角英数字で入力してください`
  }
})


extend('minmax', {
  validate(value, { min, max }) {
    return value.length >= min && value.length <= max;
  },
  params: ['min', 'max'],
  message:(fieldName,placeholders)=>{
    return `${fieldName}は${placeholders.min}字以上${placeholders.max}字以下で入力してください`
  }
});

export  {ValidationProvider,ValidationObserver}