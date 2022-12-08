<template>
    <div class="home">
        <NavbarVue></NavbarVue>
        <div class="">
            <Card v-show="!viewForm" @updateStudentsFunc="updateStudentsFunc"></Card>
            <FromVue v-show="viewForm" :studentsDataProps="studentsData"></FromVue>
        </div>
        <Copyright></Copyright>
    </div>
</template>

<script>
import NavbarVue from '@/components/Navbar.vue';
import Card from '@/components/Card.vue'
import Copyright from '@/components/Copyright.vue'
import FromVue from '@/components/From.vue';
export default {
    name: 'HomePage',
    components:{
        NavbarVue,
        Card,
        Copyright,
        FromVue
        
    },
    methods:{
        updateStudentsFunc(item){
          this.studentsData = item
          this.viewForm = true;
        }
      },
        data(){
          return{
            viewForm : false,
            studentsData : null
          
        }
      }
}
</script>

<style>

</style>