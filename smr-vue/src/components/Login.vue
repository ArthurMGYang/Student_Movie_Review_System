<template>
  <body id="paper">
  <el-form class="login-container" label-position="left" label-width="0px">
    <h3 class="login-title">User Log in</h3>
    <el-form-item>
      <el-input type="text" v-model="loginForm.username" auto-complete="off"
                placeholder="please input your username"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.password" auto-complete="off"
                placeholder="please input your password"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="login">Login
      </el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>

export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      responseResult: []
    }
  },
  methods: {
    login () {
      const _this = this
      console.log(this.$store.state)
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
            // var data = this.loginForm
            _this.$store.commit('login', _this.loginForm)
            const path = this.$route.query.redirect
            this.$router.replace({path: path === '/' || path === undefined ? '/index' : path})
          }
        })
        .catch(failResponse => {
        })
    }
  }
}
</script>
<style>
#paper {
  background: url("../assets/R&M_background.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

body {
  margin: -5px 0px;
}

.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login-title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>
