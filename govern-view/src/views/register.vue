<template>
  <v-app class="homeBox">
    <v-main class="d-flex justify-center align-center">
      <v-col cols="10" lg="4" class="mx-auto">
        <v-card class="pa-4 elevation-16">
          <div class="text-center">
            <h2 class="text--darken-3 blue--text">Govern Register</h2>
          </div>
          <v-form @submit.prevent="submitHandler" ref="form">
            <v-card-text>
              <v-text-field
                  v-model="name"
                  :rules="nameRules"
                  type="name"
                  label="Username"
                  placeholder="Username"
                  prepend-inner-icon="mdi-account"
              />
              <v-text-field
                  v-model="password"
                  :rules="passwordRules"
                  :type="passwordShow ? 'text' : 'password'"
                  label="Password"
                  placeholder="Password"
                  prepend-inner-icon="mdi-key"
                  :append-icon="passwordShow ? 'mdi-eye' : 'mdi-eye-off'"
                  @click:append="passwordShow = !passwordShow"
              />
              <v-text-field
                  v-model="password"
                  :rules="passwordRules"
                  :type="passwordShow ? 'text' : 'password'"
                  label="Confirm Password"
                  placeholder="Confirm Password"
                  prepend-inner-icon="mdi-key"
                  :append-icon="passwordShow ? 'mdi-eye' : 'mdi-eye-off'"
                  @click:append="passwordShow = !passwordShow"
              />
            </v-card-text>
            <v-card-actions class="justify-center">
              <v-btn
                  :loading="loading"
                  color="primary"
                  elevation="6"
                  type="submit"
              >
                <span class="px-16">Register</span>
              </v-btn>
            </v-card-actions>
          </v-form>
        </v-card>
      </v-col>
    </v-main>
    <v-snackbar top color="green" v-model="snackbar">
      Login Success
    </v-snackbar>
  </v-app>
</template>

<script>
export default {
  name: "register",
  data: () => ({
    loading:false,
    snackbar:false,
    passwordShow:false,
    name: '',
    nameRules: [
      v => !!v || 'Name is required',
      v => (v && v.length <= 10) || 'Name must be less than 10 characters',
    ],
    password: '',
    passwordRules: [
      v => !!v || 'Password is required',
      v => (v && v.length >= 8) || 'Password must be more than 8 characters',
    ],
  }),
  components: {},
  methods: {
    submitHandler(){
      if (this.$refs.form.validate()){
        this.loading = true
        setTimeout(()=>{
          this.loading = false
          this.snackbar = true
        },2000)
      }
    }
  }
}
</script>

<style scoped>
.homeBox {
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0px;
  background-image: linear-gradient(-225deg, #CBBACC 0%, #2580B3 100%);
}
</style>
