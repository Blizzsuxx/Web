
Vue.component("web-shop", {
	data: function () {
		return {
		  checked1: true,
		  checked2: false,
		  checked3: false,
		  checked4: false,
		  checked5: false,
		  checked6: false,
		  checked7: false,
		  checked8: false,
		  products: null,
		};
	  },
	template: ` 
<div>
	Raspoloživi proizvodi:
	<table border="1">
	<tr bgcolor="lightgrey">
		<th>Naziv</th>
		<th>Cena</th>
		<th>&nbsp;</th>
	</tr>
		
	<tr v-for="p in products">
		<td>{{p.name }}</td>
		<td>{{p.price}}</td>
		<td>
			<input type="number" style="width:40px" size="3" v-model="p.count" name="itemCount"> 
			<input type="hidden" name="itemId" v-model="p.id"> 
			<button v-on:click="addToCart(p)">Dodaj</button>
		</td>
	</tr>
</table>
	<p>
		<a href="#/sc">Pregled sadržaja korpe</a>
	</p>
	<template>
  <div>
    <el-checkbox v-model="checked1" label="Option 1"></el-checkbox>
    <el-checkbox v-model="checked2" label="Option 2"></el-checkbox>
  </div>
  <div>
    <el-checkbox v-model="checked3" label="Option 1" size="medium"></el-checkbox>
    <el-checkbox v-model="checked4" label="Option 2" size="medium"></el-checkbox>
  </div>
  <div>
    <el-checkbox v-model="checked5" label="Option 1" size="small"></el-checkbox>
    <el-checkbox v-model="checked6" label="Option 2" size="small"></el-checkbox>
  </div>
  <div>
    <el-checkbox v-model="checked7" label="Option 1" size="mini"></el-checkbox>
    <el-checkbox v-model="checked8" label="Option 2" size="mini"></el-checkbox>
  </div>
</template>




</div>		  
`
	, 
	methods : {
		addToCart : function (product) {
			axios
			.post('rest/proizvodi/add', {"id":''+product.id, "count":parseInt(product.count)})
			.then(response => (toast('Product ' + product.name + " added to the Shopping Cart")))
		}
	},
	mounted () {
        axios
          .get('rest/proizvodi/getJustProducts')
          .then(response => (this.products = response.data))
    },
});