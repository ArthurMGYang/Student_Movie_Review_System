<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
    </el-aside>
    <el-main>
      <reviews class="reviews-area" ref="reviewArea"></reviews>
    </el-main>
  </el-container>
</template>

<script>
import Reviews from './Reviews'
export default {
  name: 'ReviewIndex',
  components: {Reviews}
}
</script>

<style scoped>
.reviews-area{
  width: 990px;
  margin-left: auto;
  margin-right: auto;
}
</style>
