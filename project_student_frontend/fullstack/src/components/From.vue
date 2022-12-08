<template>
  <div>
    <router-link to="/" >
      <button type="button" class="btn btn-primary m-5"  v-show="!success">Back</button>
    </router-link>
     <div class="d-flex justify-content-center my-5">
         <div class="col-md-8">
           <form @submit.prevent="inputStudents" v-show="!success"
             action=""
             class="shipping p-5"
             id="formShipping"
             style="border: 3px solid pink"
           >
             <h1 style="text-align: center">{{ $route.name }} Student</h1>
             <div class="row">
               <div class="mb-3 col-md-6">
                 <label for="name">Student Name</label>
                 <input
                   v-model="studentsData.nama"
                   class="form-control"
                   type="text"
                   placeholder="Enter name"
                   id="student_name"
                   required

                 />
               </div>
               <div class="mb-3 col-md-6">
                 <label for="phone number">Soft Skills</label>
                 <input
                   v-model="studentsData.soft_skill"
                   class="form-control"
                   type="text"
                   placeholder="Enter soft skills"
                   id=""
                   required
                 />
               </div>
               <div class="mb-3 col-md-3">
                 <label for="last name">Student Age</label>
                 <input
                   v-model="studentsData.umur"
                   class="form-control"
                   type="number"
                   placeholder="Enter age"
                   id=""
                   required
                 />
               </div>
               <div class="mb-3 col-md-3">
                   <label for="exampleFormControlSelect1">Gender</label>
                   <select class="form-control" id="exampleFormControlSelect1" v-model="studentsData.jenis_kelamin" required>
                       <option selected></option>
                       <option value="Male">Male</option>
                       <option value="Female">Female</option>
                   </select>
               </div>
               <div class="mb-3 col-md-6">
                 <label for="hard_skills">Hard Skills</label>
                 <input
                   v-model="studentsData.hard_skill"
                   class="form-control"
                   type="text"
                   placeholder="Enter hard skills"
                   id=""
                   required
                 />
               </div>
               <div class="mb-3 col-md-6">
                 <label for="first name">Student Email</label>
                 <input
                   v-model="studentsData.email"
                   class="form-control"
                   type="email"
                   placeholder="Enter email"
                   id="email"
                   required
                 />
               </div>
               <div class="mb-3 col-md-6">
                   <label for="exampleFormControlSelect1">Interest</label>
                   <select class="form-control" id="exampleFormControlSelect1" v-model="studentsData.interest" required>
                       <option selected></option>
                       <option value="Data science">Data Science</option>
                       <option value="Network">Network</option>
                       <option value="Web Frontend">Web Frontend</option>
                       <option value="Web Backend">Web Backend</option>
                       <option value="Mobile Apps">Mobile Apps</option>
                   </select>
               </div>
               <div class="mb-3 col md-12">
                   <label for="">Self Description</label>
                   <div class="input-group">
                     <textarea
                       v-model="studentsData.deskripsi_diri"
                       class="form-control"
                       name=""
                       id=""
                       placeholder="Enter address"
                       required
                     ></textarea>
               </div>
               <div class="p-3 col-md-6">
                   <button
                   type="submit"
                   class="btn"
                   style="background-color: pink"
                   id="btnSubmitShipping"
                   >
                   {{buttonValue}}
               </button>
           </div>
       </div>
             </div>
           </form>
           <!-- Success Section -->
           <SuccessForm v-show="success"></SuccessForm>
         </div>
       </div>
 </div>
</template>

<script>
import studentsService from '@/service/service';
import SuccessForm from "./SuccessForm.vue"
export default {
   data(){
       return{
           studentsData:{
               nama : null,
               soft_skill : null,
               umur : null,
               jenis_kelamin : null,
               hard_skill : null,
               email : null,
               interest : null,
               deskripsi_diri : null
           },
           success : false,
           buttonValue : "Submit",
          //  message : "Student Data Has Been Inputed!",

       };
   },
   methods:{
       inputStudents(){
         let data = this.studentsData;
         if (this.buttonValue === "Submit") {
           studentsService.create(data)
           .then(response => {
               console.log(response.data);
               this.success = true;
             }).catch(e =>{
               console.log(e)
             });
         } else {
           studentsService.updateStudents(data.id, data)
           .then(response => {
               console.log(response.data);
               this.success = true;
             }).catch(e =>{
               console.log(e)
             });
         }
       },
     },
   name: 'fromPage', 
   components:{
       SuccessForm
   },
   props:["studentsDataProps"],
   watch:{
       'studentsDataProps'(newValue){
        this.studentsData = newValue;
        console.log(this.studentsData);
        this.buttonValue = "Update"
       }
   },
   mounted(){
     if (this.$route.name == 'Update') {
       this.buttonValue = 'Update';
       studentsService.getStudent(this.$route.params.id)
       .then(response =>{
         this.studentsData= response.data
       }).catch(e =>{
         console.log(e)
       })
     }
}
}
</script>

<style>

</style>