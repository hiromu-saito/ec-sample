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
                v-for="(category) in categories"
                :value="category.title"
                :key="category.id">
                {{category.title}}
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
          <tr
            v-for="result in results "
            :key="result.code">
            <td><input type="checkbox"/></td>
            <td>{{result.code}}</td>
            <td>{{result.name}}</td>
            <td>{{result.distributor}}</td>
            <td>{{result.price}}</td>
            <td>{{result.memo}}</td>
            <td><input/></td>
          </tr>
        </tbody>
      </table>
      <button>お買い物かごにいれる</button>
    </div>
  </div>
</template>

<script>
const categoryUrl = "http://localhost:3000/categories"
const searchUrl = "http://localhost:3000/search"
export default {
  name: "Search",
  data(){
    return{
      searched:false,
      categories:[],
      results:[]
    }
  },
  methods:{
    async search(){
      //API呼び出し
      this.results = await
      fetch(searchUrl)
      .then(response => response.json())
      this.searched = true
    }
  },
  async mounted(){
    //API呼び出してカテゴリを取得
    //仮実装
    this.categories = await
    fetch(categoryUrl)
    .then(response => response.json())
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