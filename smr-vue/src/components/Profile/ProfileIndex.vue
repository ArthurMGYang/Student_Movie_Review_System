<template>
  <div>
    <h3 class="welcome">Hello {{user.username}}! this is your profile page!</h3>
    <p>uid: {{user.id}}</p>
    <p>Previous Reviews</p>
    <div class="review_area" v-for="item in reviews"
         :key="item.id">
      <i class="el-icon-delete" @click="deleteReview(item.id)"></i>
      <el-descriptions title="Previous Review" direction="vertical" :column="4" border>
        <el-descriptions-item label="movie">{{item.movie.title}}</el-descriptions-item>
        <el-descriptions-item label="Recommended Rating">{{ item.rank1 }}</el-descriptions-item>
        <el-descriptions-item label="Content rating">{{item.rank2}}</el-descriptions-item>
        <el-descriptions-item label="review content">{{item.content}}</el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ProfileIndex',
  data () {
    return {
      user: [],
      reviews: []
    }
  },
  mounted: function () {
    this.loadUserInfo()
    this.loadReviewInfo()
  },
  methods: {
    loadUserInfo () {
      const username = JSON.parse(localStorage.getItem('user')).username
      const _this = this
      this.$axios.get('users/' + username).then(resp => {
        if (resp && resp.status === 200) {
          _this.user = resp.data
        }
      })
    },
    loadReviewInfo () {
      const username = JSON.parse(localStorage.getItem('user')).username
      const _this = this
      this.$axios.get('reviews/users/' + username).then(resp => {
        if (resp && resp.status === 200) {
          _this.reviews = resp.data
        }
      })
    },
    deleteReview (id) {
      this.$confirm('this action may cause serious result, will you continue', 'hint', {
        confirmButtonText: 'confirm',
        cancelButtonText: 'cancel',
        type: 'warning'
      }).then(() => {
        this.$axios
          .post('/review/delete', {id: id}).then(resp => {
            if (resp && resp.status === 200) {
              this.loadReviewInfo()
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

</style>
