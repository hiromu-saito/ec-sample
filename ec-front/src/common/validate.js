import {
  extend,
  ValidationProvider,
  ValidationObserver
} from 'vee-validate'

import {
  required,
  // confirmed,
  // regex,
}from  'vee-validate/dist/rules';

extend('required',  {
  ...required,
  params:['min'],
  message:(fieldName)=>{
    return `${fieldName}は必須です`
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