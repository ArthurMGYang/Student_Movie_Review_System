<template>
  <div>
    <el-row style="height: 840px;">
      <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
      <el-tooltip effect="dark" placement="right"
                  v-for="item in movies"
                  :key="item.id">
        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.title}}</p>
        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">Movie id: {{item.id}}</p>
        <p slot="content" style="font-size: 13px;margin-bottom: 6px">
          <span>Director: {{item.director}}</span><br/>
          <span>Starring: {{item.starring}}</span>
        </p>
        <el-card style="width: 160px;margin-bottom: 20px;height: 220px;float: left;margin-right: 15px" class="movie"
                 bodyStyle="padding:10px" shadow="hover">
          <div class="cover" @click="editMovie(item)">
            <img :src="item.cover" alt="cover">
          </div>
          <div class="info">
            <div class="title">
              <a href="">{{item.title}}</a>
            </div>
            <i class="el-icon-delete" @click="deleteMovie(item.id)"></i>
          </div>
        </el-card>
      </el-tooltip>
      <edit-form @onSubmit="loadMovies" ref="edit"></edit-form>
    </el-row>
<!--    <el-row>-->
<!--      <el-pagination-->
<!--        @current-change="handleCurrentChange"-->
<!--        :current-page="currentPage"-->
<!--        :page-size="pageSize"-->
<!--        :total="movies.length">-->
<!--      </el-pagination>-->
<!--    </el-row>-->
  </div>
</template>

<script>
import EditForm from './EditForm'
import searchBar from './searchBar'
export default {
  name: 'Movies',
  components: {EditForm, searchBar},
  data () {
    return {
      movies: [],
      currentPage: 1,
      pageSize: 20
    }
  },
  mounted: function () {
    this.loadMovies()
  },
  methods: {
    loadMovies () {
      const _this = this
      this.$axios.get('/movies').then(resp => {
        if (resp && resp.status === 200) {
          _this.movies = resp.data
        }
      })
    },
    searchResult () {
      const _this = this
      this.$axios
        .post('/search?keywords=' + this.$refs.searchBar.keywords)
        .then(resp => {
          if (resp && resp.status === 200) {
            _this.movies = resp.data
          }
        })
    },
    deleteMovie (id) {
      const username = JSON.parse(localStorage.getItem('user')).username
      if (username === 'admin') {
        this.$confirm('this action may cause serious result, will you continue', 'hint', {
          confirmButtonText: 'confirm',
          cancelButtonText: 'cancel',
          type: 'warning'
        }).then(() => {
          this.$axios
            .post('/movie/delete', {id: id}).then(resp => {
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
      } else {
        this.$message({
          type: 'info',
          message: 'Sorry you do not have authority to delete movies'
        })
      }
    },
    editMovie (item) {
      const username = JSON.parse(localStorage.getItem('user')).username
      if (username === 'admin') {
        this.$refs.edit.dialogFormVisible = true
        this.$refs.edit.form = {
          id: item.id,
          cover: item.cover,
          title: item.title,
          director: item.director,
          starring: item.starring,
          data: item.date,
          link: item.link,
          rank: 0,
          total_rank: 0,
          rank_people: 0,
          public_resource: item.public_resource,
          category: {
            id: item.category.id.toString(),
            name: item.category.name
          }
        }
      }
    }
  }
}
</script>

<style scoped>
.cover {
  width: 150px;
  height: 172px;
  margin-bottom: 7px;
  overflow: hidden;
  cursor: pointer;
}

img {
  width: 135px;
  height: 172px;
  margin: 0 auto;
}

.title {
  font-size: 10px;
  text-align: left;
}

.info {
  color: #333;
  width: 102px;
  font-size: 10px;
  margin-bottom: 6px;
  text-align: middle;
}
.el-icon-delete{
  cursor: pointer;
  float: right;
}

.switch{
  display: fixed;
  position: absolute;
  left: 780px;
  top: 25px;
}

a {
  text-decoration: none;
}

a:link, a:visited, a:focus {
  color: #3377aa;
}
</style>
