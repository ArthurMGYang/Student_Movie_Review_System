<template>
  <el-menu class="menu"
    :default-active="'/index'"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="red"
    style="min-width: 1300px">
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>
    <i class="el-icon-switch-button" v-on:click="logout" style="float:right;font-size: 40px;color: #222;padding: 10px"></i>
    <span style="position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold">Student Movie Review System</span>
  </el-menu>
</template>

<script>
export default {
  name: 'NavMenu',
  data () {
    return {
      navList: [
        {name: '/index', navItem: 'Homepage'},
        {name: '/reviews', navItem: 'Reviews'},
        {name: '/library', navItem: 'Library'},
        {name: '/profile', navItem: 'profile'}
      ]
    }
  },
  methods: {
    logout () {
      const _this = this
      this.$axios.get('/logout').then(resp => {
        if (resp.data.code === 200) {
          _this.$store.commit('logout')
          _this.$router.replace('/login')
        }
      })
    }
  }
}
</script>

<style scoped>
.menu{
  margin: -50px auto 0px auto
}
a{
  text-decoration: none;
}

span {
  pointer-events: none;
}
.el-icon-switch-button {
  cursor: pointer;
  outline:0;
}
</style>
