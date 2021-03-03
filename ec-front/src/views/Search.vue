<template>
  <div>
    <h1>商品検索</h1>
    <div class="search">
      <p>検索条件を入力してください</p>
      <table>
        <tr>
          <th>カテゴリ</th>
          <td>
            <select>
              <option 
                v-for="(category,index) in categories"
                :value="category"
                :key="index">
                {{category}}
              </option>
            </select>
          </td>
        </tr>
        <tr>
          <th>商品名</th>
          <td><input/></td>
        </tr>
        <tr>
          <th>販売元</th>
          <td><input/></td>
        </tr>
        <tr>
          <th>金額上限</th>
          <td><input/></td>
        </tr>
        <tr>
          <th>金額下限</th>
          <td><input/></td>
        </tr>
      </table>
      <p>
        <button @click="search">検索</button>
        <button @click="$router.push('/')">戻る</button>
        <button>クリア</button>
      </p>
    </div>
    <div v-if="searched" class="search_list">
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
          <tr>
            <td><input type="checkbox"/></td>
            <td>0000-0000</td>
            <td>商品001</td>
            <td>販売元001</td>
            <td>1000</td>
            <td>素晴らしい商品</td>
            <td><input/></td>
          </tr>
        </tbody>
      </table>
      <button>お買い物かごにいれる</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Search",
  data(){
    return{
      searched:false,
      categories:[]
    }
  },
  methods:{
    search(){
      //API呼び出し
      this.searched = true
    }
  },
  beforeRouteEnter(to,from,next){
    //API呼び出してカテゴリを取得
    //仮実装
    next(vm =>{
      vm.categories =  ['カテゴリ1','カテゴリ2','カテゴリ3']
    })
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
  border: 1px solid ;
}
.search_list th{
  background-color: pink;
}
.page span{
  display: inline-block;
  margin: 0 5px 0 5px;
}
</style>