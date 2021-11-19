<template>
  <body id="paper">
  <el-form class="register-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="register-title">User Register</h3>
    <el-form-item>
      <el-input type="text" v-model="registerForm.username"
                auto-complete="off" placeholder="Username"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="registerForm.password"
                auto-complete="off" placeholder="Password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="registerForm.phone" autocomplete="off" placeholder="phone number"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="registerForm.email" autocomplete="off" placeholder="email"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="registerForm.school" autocomplete="off" placeholder="school name"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="register">Register!</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>
<script>
export default{
  data () {
    return {
      rules: {
        username: [{required: true, message: 'Username can not be empty', trigger: 'blur'}],
        password: [{required: true, message: 'Password can not be empty', trigger: 'blur'}]
      },
      checked: true,
      registerForm: {
        username: '',
        password: '',
        phone: '',
        email: '',
        school: ''
      },
      loading: false
    }
  },
  methods: {
    register () {
      const _this = this
      this.$axios
        .post('/register', {
          username: this.registerForm.username,
          password: this.registerForm.password,
          phone: this.registerForm.phone,
          email: this.registerForm.email,
          school: this.registerForm.school
        })
        .then(resp => {
          if (resp.data.code === 200) {
            this.$alert('successful', 'hint', {
              confirmButtonText: 'confirm'
            })
            _this.$router.replace('/login')
          } else {
            this.$alert(resp.data.message, 'hint', {
              confirmButtonText: 'confirm'
            })
          }
        })
        .catch(failResponse => {})
    }
  }
}
</script>
<style>
#paper {
  background:url("../assets/R&M_background.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body{
  margin: -5px 0px;
}
.register-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.register-title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>
