<template>
  <div class="home">
    <v-img @click="click" style="width: 320px" alt="vue logo" src="../assets/logo.png"/>
  </div>
</template>

<script>

  export default {
    name: 'Home',
    components: {
    },
    methods: {
      click() {
        this.$ajax.get('/hello').then((res) => {
          console.log(res);
        }).catch((err) => {
          console.log(err)
        })
      }
    }
  }
</script>
