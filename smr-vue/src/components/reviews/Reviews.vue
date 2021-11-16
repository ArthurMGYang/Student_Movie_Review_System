<template>
  <div>
    <el-row style="height: 840px;">
      <div v-for="item in reviews.slice((currentPage-1)*pageSize,currentPage*pageSize)"
                  :key="item.id">
        <p>Reviews by {{item.user.username}}</p>
        <el-descriptions class="review_area" direction="vertical" :column="3" border>
          <el-descriptions-item label="movie">{{item.movie.title}}</el-descriptions-item>
          <el-descriptions-item label="Recommended Rating">{{ item.rank1 }}</el-descriptions-item>
          <el-descriptions-item label="Content rating">{{item.rank2}}</el-descriptions-item>
          <el-descriptions-item label="review content">{{item.content}}</el-descriptions-item>
          <el-descriptions-item label="watch place">{{item.watchPlace}}</el-descriptions-item>
          <el-descriptions-item label="watch date">{{item.watchDate}}</el-descriptions-item>
        </el-descriptions>
      </div>
      <add-review @onSubmit="loadReviews" ref="edit"></add-review>
    </el-row>
    <el-row>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pageSize"
        :total="reviews.length">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
import AddReview from './AddReview'
export default {
  name: 'Reviews',
  components: {AddReview},
  data () {
    return {
      reviews: [],
      currentPage: 1,
      pageSize: 20
    }
  },
  mounted: function () {
    this.loadReviews()
  },
  methods: {
    loadReviews () {
      const _this = this
      this.$axios.get('/reviews').then(resp => {
        if (resp && resp.status === 200) {
          _this.reviews = resp.data
        }
      })
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      console.log(this.currentPage)
    },
    deleteMovie (id) {
      this.$confirm('this action may cause serious result, will you continue', 'hint', {
        confirmButtonText: 'yes',
        cancelButtonText: 'cancel',
        type: 'warning'
      }).then(() => {
        this.$axios
          .post('/delete', {id: id}).then(resp => {
            if (resp && resp.status === 200) {
              this.loadMovies()
            }
          })
      }
      ).catch(() => {
        this.$message({
          type: 'info',
          message: 'cancel delete'
        })
      })
    }
  }
}
</script>

<style scoped>
.review_area{
  padding-left: 0px;
}
</style>
