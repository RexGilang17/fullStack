<template>
    <div class="">
        <router-link to="/add" v-show="!success">
            <button type="button" class="btn btn-primary m-5">Add Data</button>
        </router-link>
        <div class="row d-flex">
        <div class="card m-5 border" v-for="item in studentsData" :key="item.id" style="border-radius:20px; " v-show="!success">
                <div class="card-body">
                  <h3 class="card-title">{{ item.nama }}, {{ item.umur }} Years Old</h3>
                  <h5>{{item.deskripsi_diri}}</h5>
                  <br>
                  <table  width="100%">
                  <tr>
                      <td>Email</td>
                      <td width="100%">: {{item.email}}</td>
                  </tr>
                  <tr>
                      <td>Soft Skill</td>
                      <td>: {{item.soft_skill}}</td>
                  </tr>
                  <tr>
                      <td>Hard Skill</td>
                      <td>: {{item.hard_skill}}</td>
                      
                  </tr>
                  <tr>
                      <td>Interest</td>
                      <td>: {{item.interest}}</td>
                      <td></td>
                  </tr> <br> <br> 
                  <tr>
                      <td>
                          <router-link :to="`/update/${item.id}`">
                               <button type="button" class="btn btn-primary m-2">Update</button>
                           </router-link>
                          
                          </td>
                      <td><button type="button" class="btn btn-danger" @click="deleteStudentsFunc(item.id)">Delete</button></td>
                          
                      <td></td>
                      <td> <img v-if="item.jenis_kelamin == 'Male'" src="@/assets/male.png" alt="" width="30px">
                           <img v-if="item.jenis_kelamin == 'Female'" src="@/assets/female.png" alt="" width="25px"></td>
                  </tr>
              </table>
            </div>
            
        </div>
        <div class="form_delete">
        <SuccessFormVue  v-show="success"></SuccessFormVue>
    </div>
          </div>
    </div>
  
  </template>
  
  <script>
  import studentsService from '@/service/service'
  import SuccessFormVue from './SuccessForm.vue';
  export default {
      name: 'cardPage',
      components:{
        SuccessFormVue,
      },
      methods : {
          getStudents(){
              studentsService.getAll()
                  .then(response => {
                      this.studentsData = response.data;
                      console.log(this.studentsData);
                  })
                  .catch(e => {
                      console.log(e);
                  });
          },
          deleteStudentsFunc(id){
              if (confirm("Are You Sure Want to Delete?")) {
                  studentsService.deleteStudents(id)
                  .then(response=> {
                      console.log(response.data);
                    this.success= true;
                  })
                  .catch(e=>{
                      console.log(e);
                  });
  
              }else{
                  alert("Hapus dibatalkan!")
              }
          }
      },
      mounted(){
          this.getStudents();
      },
      data(){
          return{
              studentsData : null,
              success: false
          }
      }
  }
  </script>
  
  <style scoped>
  
  img{
      margin: 10px;
  }

  .form_delete{
    text-align: center;
    margin-left: 550px;
    margin-bottom:100px ;
  }
   
  </style>