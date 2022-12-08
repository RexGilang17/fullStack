<template>
    <div class="">
      <NavbarVue></NavbarVue>
      <FromVue></FromVue>
      <Copyright></Copyright>
  </div>
</template>

<script>
import NavbarVue from '@/components/Navbar.vue';
import FromVue from '@/components/From.vue';
import Copyright from '@/components/Copyright.vue'
export default {
    name: 'AddPage',
    components:{

        NavbarVue,
        FromVue,
        Copyright
    },
    // data(){
    //     return{
    //         message : "Student Data Has Been Inputed!"
    //     }
    // }
}
</script>

<style>

</style>