<template>
  <div class="cards">
    <div class="card-body">
      <h5 class="card-title">Success!</h5>
      <p class="card-text">Student Data Has Been {{ Judul }} !</p>
      <router-link to="/" v-if="Judul === 'Submit'">
        <button class="btn btn-primary mt-3 ml-3">Back</button>
      </router-link>
      <router-link to="/" v-else-if="Judul === 'Update'">
        <button id="btn" class="btn btn-primary mt-3 ml-3">Back</button>
      </router-link>
      <button class="btn btn-primary" @click="RefreshFunc" v-else>
        Close
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "SuccessForm",

  data() {
    return {
      Judul: null,
    };
  },

  methods: {
    ubahJudul() {
      let route = this.$route.fullPath;
      if (route === "/add") {
        this.Judul = "Submit";
      } else if (route === "/") {
        this.Judul = "Delete";
      } else {
        this.Judul = "Update";
      }
    },
    RefreshFunc() {
      location.reload();
    },
  },

  mounted() {
    this.ubahJudul();
  },
};
</script>

<style scoped>
.border-color-pink {
  border: solid 2px #f9cada;
}

.bg-color-pink {
  background-color: #f9caca;
}

.cards {
  border-radius: 10px;
  border: 1px solid red;
  margin-top: 20px;
  padding-left: 100px;
  padding-right: 100px;
}

#btn {
  margin-left: 100px;
}
</style>