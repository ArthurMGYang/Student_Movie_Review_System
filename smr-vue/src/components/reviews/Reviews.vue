<template>
  <div>
      <div v-for="item in reviews"
                  :key="item.id">
        <p>
          Reviews by {{item.user.username}}
          <i v-if='currentUsername === "admin"' class="el-icon-delete" @click="deleteReview(item.id)"></i>
        </p>
        <el-descriptions class="review_area" direction="vertical" :column="3" border>
          <el-descriptions-item label="movie">{{item.movie.title}}</el-descriptions-item>
          <el-descriptions-item label="Recommended Rating">{{ item.rank1 }}</el-descriptions-item>
          <el-descriptions-item label="Content rating">{{item.rank2}}</el-descriptions-item>
          <el-descriptions-item label="review content">{{item.content}}</el-descriptions-item>
          <el-descriptions-item label="watch place">{{item.watchPlace}}</el-descriptions-item>
          <el-descriptions-item label="watch date">{{item.watchDate}}</el-descriptions-item>
        </el-descriptions>
      </div>
    <el-row>
    </el-row>
    <add-review @onSubmit="loadReviews" ref="edit"></add-review>
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
      currentUsername: JSON.parse(localStorage.getItem('user')).username
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
    deleteReview (id) {
      const username = JSON.parse(localStorage.getItem('user')).username
      if (username === 'admin') {
        this.$confirm('this action may cause serious result, will you continue', 'hint', {
          confirmButtonText: 'confirm',
          cancelButtonText: 'cancel',
          type: 'warning'
        }).then(() => {
          this.$axios
            .post('/review/delete', {id: id}).then(resp => {
              if (resp && resp.status === 200) {
                this.loadReviews()
              }
            })
        }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: 'cancel delete'
          })
        })
      } else {
        this.$message({
          type: 'info',
          message: 'Sorry you do not have authority to delete reviews'
        })
      }
    }
  }
}
</script>

<style scoped>
.review_area{
  padding-left: 0px;
}
</style>
