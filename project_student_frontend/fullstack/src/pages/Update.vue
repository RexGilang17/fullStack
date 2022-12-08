<template>
  <div class="">
    <div class="image">
    <img src="@/assets/img_code.jpg" alt="Naav">
  </div>
    <!-- <NavbarVue></NavbarVue> -->
    <FromVue></FromVue>
    <CopyrightVue></CopyrightVue>
  </div>
</template>

<script>
// import NavbarVue from '@/components/Navbar.vue';
import FromVue from '@/components/From.vue';
import CopyrightVue from '@/components/Copyright.vue';
export default {
name: 'updatePage',
components: {
    // NavbarVue,
    FromVue,
    CopyrightVue,
},

}
</script>

<style scoped>
.image img {
  height: 100%;
  width: 100%;
}
</style>