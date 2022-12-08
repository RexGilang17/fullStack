<template>
  <div class="image">
    <img src="@/assets/img_code.jpg" alt="img">
    
    <!-- <router-link to="/add" v-show="CurrentRoutPath == '/'">
        <button type="button" class="btn btn-primary">Add Data</button>
    </router-link> -->
    <!-- <router-link to="/" v-show="CurrentRoutPath == '/add'">
        <button type="button" class="btn btn-primary">Back</button>
    </router-link>
    <router-link to="/" v-show="CurrentRoutName == 'update'">
        <button type="button" class="btn btn-primary" >Back</button>
    </router-link> -->
  </div> 
</template>

<script>

export default {
name: 'NavbarComponentView',
// computed:{
//     CurrentRoutPath(){
//         return this.$route.path
//     },
//     CurrentRoutName(){
//         return this.$route.name
//     }

// },  
}
</script>

<style scoped>
.image img {
    height: 100%;
    width: 100%;
}
button{
    margin: 40px;
}
</style>