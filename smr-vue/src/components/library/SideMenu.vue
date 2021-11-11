<template>
  <el-menu
    class="categories"
    default-active="0"
    @select="handleSelect"
    active-text-color="red">
    <el-menu-item index="0">
      <!--      <i class="el-icon-menu"></i>-->
      <span slot="title">All</span>
    </el-menu-item>
    <el-menu-item index="1">
      <!--      <i class="el-icon-menu"></i>-->
      <span slot="title">Cartoon</span>
    </el-menu-item>
    <el-menu-item index="2">
      <!--      <i class="el-icon-menu"></i>-->
      <span slot="title">Sci-fi movie</span>
    </el-menu-item>
    <el-menu-item index="3">
      <!--      <i class="el-icon-menu"></i>-->
      <span slot="title">Documentary</span>
    </el-menu-item>
    <el-menu-item index="4">
      <!--      <i class="el-icon-menu"></i>-->
      <span slot="title">Horror</span>
    </el-menu-item>
    <el-menu-item index="5">
      <!--      <i class="el-icon-menu"></i>-->
      <span slot="title">Comedy</span>
    </el-menu-item>
    <el-menu-item index="6">
      <!--      <i class="el-icon-menu"></i>-->
      <span slot="title">Romance</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: 'SideMenu',
  data () {
    return {
      categoryID: ''
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      this.categoryID = key
      this.$emit('indexSelect')
    }
  }
}
</script>

<style scoped>
.categories {
  position: fixed;
  margin-left: 0%;
  left: 0px;
  top: 100px;
  width: 150px;
}
</style>
