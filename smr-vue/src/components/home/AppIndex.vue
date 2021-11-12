<template>
  <div>
    <el-collapse v-model="activeNames" @change="handleChange">
      <el-collapse-item title="Homepage" name="1">
        <div>This is the page where you are now!</div>
        <div>Have fun exploring in this Student Movie Review System!</div>
      </el-collapse-item>
      <el-collapse-item title="Reviews" name="2">
        <div>This is the page where you can look through or make your own reviews on movies</div>
        <div>Feel free to comment, but pay attention to your words</div>
      </el-collapse-item>
      <el-collapse-item title="Library" name="3">
        <div>This is the page where you can look through all the movies in the system</div>
        <div>Check out if there is one you love!</div>
      </el-collapse-item>
      <el-collapse-item title="Profile" name="4">
        <div>This is the page where you can look through your own information</div>
      </el-collapse-item>
    </el-collapse>
    <el-carousel :interval="3000" type="card" height="500px">
      <el-carousel-item>
        <img src="https://i.loli.net/2021/10/21/1RVQGw7hc8WPoKS.jpg" class="carousel_image_type">
      </el-carousel-item>
      <el-carousel-item>
        <img src="https://i.loli.net/2021/10/21/5pmudEXysjO7YaQ.jpg" class="carousel_image_type">
      </el-carousel-item>
      <el-carousel-item>
        <img src="https://i.loli.net/2021/10/21/m6zPvFIjQV9Ma3U.jpg" class="carousel_image_type">
      </el-carousel-item>
      <el-carousel-item>
        <img src="https://i.loli.net/2021/10/21/AoK9fMJkRgZxHeu.jpg" class="carousel_image_type">
      </el-carousel-item>
      <el-carousel-item>
        <img src="https://i.loli.net/2021/10/21/xeGsfjnwYAy4P59.jpg" class="carousel_image_type">
      </el-carousel-item>
      <el-carousel-item>
        <img src="https://i.loli.net/2021/10/21/gwB8dArQW2tejJ9.jpg" class="carousel_image_type">
      </el-carousel-item>
    </el-carousel>
    <h3>Upcoming Movies</h3>
    <el-calendar v-model="value">
    </el-calendar>
    <el-backtop target=".page-component__scroll .el-scrollbar__wrap"></el-backtop>
  </div>
</template>

<script>
export default {
  name: 'AppIndex',
  data () {
    return {
      activeNames: ['1'],
      value: new Date()
    }
  },
  methods: {
    handleChange (val) {
      console.log(val)
    }
  }
}
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
.carousel_image_type{
  width: 100%;
}
</style>
