<template>
  <div>
    <h1>商品検索</h1>
    <div class="search">
      <p>検索条件を入力してください</p>
      <validation-observer tag="form" v-slot="{ invalid }">
        <table>
          <tr>
            <th>カテゴリ</th>
            <td>
              <select>
                <option
                  v-for="category in categories"
                  :value="category.title"
                  :key="category.id"
                >
                  {{ category.title }}
                </option>
              </select>
            </td>
          </tr>
          <tr>
            <th>商品名</th>
            <td>
              <input name="itemName" v-model="where.itemName" />
            </td>
          </tr>
          <tr>
            <th>販売元</th>
            <td>
              <input name="distributor" v-model="where.distributor" />
            </td>
          </tr>
          <tr>
            <th>金額上限</th>
            <td>
              <validation-input
                inputType="input"
                name="maxprice"
                rules="numeric|higher:@minprice"
                :value.sync="where.maxPrice"
              />
            </td>
          </tr>
          <tr>
            <th>金額下限</th>
            <td>
              <validation-input
                inputType="input"
                name="minprice"
                rules="numeric|lower:@maxprice"
                :value.sync="where.minPrice"
              />
            </td>
          </tr>
        </table>
        <p>
          <button @click.prevent="search" :disabled="invalid">検索</button>
          <button @click="$router.push('/')">戻る</button>
          <button @click.prevent="clear">クリア</button>
        </p>
      </validation-observer>
    </div>
    <div class="search_list">
      商品一覧
      <p class="page">
        <span>&lt;&lt;</span>
        <span>&lt;</span>
        1/n
        <span>&gt;&gt;</span>
        <span>&gt;</span>
      </p>
      <table>
        <thead>
          <tr>
            <th>選択</th>
            <th>商品コード</th>
            <th>商品名</th>
            <th>販売元</th>
            <th>金額（単価）</th>
            <th>メモ</th>
            <th>購入数</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="result in results"
            :key="result.code">
            <td>
              <input
                type="checkbox"
                :value="result"
                @click="selectedItems.push(result)"
                />
            </td>
            <td>{{result.code}}</td>
            <td>{{result.name}}</td>
            <td>{{result.distributor}}</td>
            <td>{{result.price}}</td>
            <td>{{result.memo}}</td>
            <td><input v-model="result.count"/></td>
          </tr>
        </tbody>
      </table>
      <p><button @click="addBacket" :disabled=addBacketValidate>お買い物かごにいれる</button></p>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import store from "../store";
import ValidationInput from "../components/ValidationInput.vue";

const categoryUrl = "http://localhost:3000/categories";
export default {
  name: "Search",
  components:{
    ValidationInput
  },
  data(){
    return{
      categories:[],
      selectedItems:[],
      where:{}
    }
  },
  async mounted(){
    //TODO 呼び出しAPIを変える
    this.categories = await fetch(categoryUrl).then((response) =>
      response.json()
    );
    this.resetResultsAction();
  },
  methods:{
    ...mapActions('search',['setResultsAction','resetResultsAction']),
    ...mapActions('backet',['addItemAction']),
    search(){
      //TODO 検索パラメータを渡す
      this.setResultsAction()
    },
    clear(){
      this.where = {}
    },
    addBacket(){
      //TODO 在庫チェック
      this.addItemAction(this.selectedItems)
      this.$router.push("/backet")
    },
  },
  computed:{
    results:() => store.state.search.results,
    addBacketValidate(){
      if (this.selectedItems.length === 0){
        return true
      }
      const valid = this.selectedItems.some(selectedItem=>{
        if(!selectedItem.count){
          return true
        }
        return selectedItem.count.match(/[^0-9]+/)
      })
      return valid
    }
  }
};
</script>

<style scoped>
.search {
  margin-left: 32px;
}
.search table,
.search th,
.search td {
  border-collapse: collapse;
}
.search th {
  width: 150px;
  background-color: pink;
  text-align: right;
}
.search td {
  vertical-align: middle;
}

.search button {
  margin-right: 10px;
}
.search_list {
  margin-left: 32px;
}
.search_list table,
.search_list th,
.search_list td {
  border: 1px solid;
}
.search_list th {
  background-color: pink;
}
.page span {
  display: inline-block;
  margin: 0 5px 0 5px;
}
</style>