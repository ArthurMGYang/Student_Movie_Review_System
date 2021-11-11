<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu @indexSelect="listByCategory" ref="SideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <movies class="movies-area" ref="moviesArea"></movies>
    </el-main>
  </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Movies from './Movies'
export default {
  name: 'AppLibrary',
  components: {Movies, SideMenu},
  methods: {
    listByCategory () {
      const _this = this
      const cid = this.$refs.SideMenu.categoryID
      const url = 'categories/' + cid + '/movies'
      this.$axios.get(url).then(resp => {
        if (resp && resp.status === 200) {
          _this.$refs.moviesArea.movies = resp.data
        }
      })
    }
  }
}
</script>

<style scoped>
.movies-area{
  width: 990px;
  margin-left: auto;
  margin-right: auto;
}
</style>
