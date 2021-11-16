<template>
  <div>
    <i class="el-icon-circle-plus-outline" @click="dialogFormVisible = true"></i>
    <el-dialog title="add/modify movie" :visible.sync="dialogFormVisible" @close="clear">
      <el-form v-model="form" style = "text-align: left" ref="dataForm">
        <el-form-item label="mid" :label-width="formLabelWidth" prop="movie">
          <el-input v-model="form.movie.id" autocomplete="off" placeholder="please input movie id"></el-input>
        </el-form-item>
        <el-form-item label="uid" :label-width="formLabelWidth" prop="user">
          <el-input v-model="form.user.id" autocomplete="off" placeholder="please input user id"></el-input>
        </el-form-item>
        <el-form-item label="rank1" :label-width="formLabelWidth" prop="rank1">
          <el-select v-model="form.rank1" placeholder="What do you think of this movie">
            <el-option label="1" value="1"></el-option>
            <el-option label="2" value="2"></el-option>
            <el-option label="3" value="3"></el-option>
            <el-option label="4" value="4"></el-option>
            <el-option label="5" value="5"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="rank1" :label-width="formLabelWidth" prop="rank2">
          <el-select v-model="form.rank2" placeholder="What do you think of this movie">
            <el-option label="1" value="1"></el-option>
            <el-option label="2" value="2"></el-option>
            <el-option label="3" value="3"></el-option>
            <el-option label="4" value="4"></el-option>
            <el-option label="5" value="5"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="watch_place" :label-width="formLabelWidth" prop="place">
          <el-input v-model="form.watchPlace" autocomplete="off" placeholder="please input where you watch it"></el-input>
        </el-form-item>
        <el-form-item label="watch_date" :label-width="formLabelWidth" prop="date">
          <el-input v-model="form.watchDate" autocomplete="off" placeholder="please input when you watch it"></el-input>
        </el-form-item>
        <el-form-item label="content" :label-width="formLabelWidth" prop="content">
          <el-input v-model="form.content" autocomplete="off" placeholder="input your review"></el-input>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="form.id" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="onSubmit">Confirm</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'AddReview',
  data () {
    return {
      dialogFormVisible: false,
      form: {
        id: '',
        rank1: '',
        rank2: '',
        content: '',
        watchDate: '',
        watchPlace: '',
        movie: {
          id: '',
          cover: '',
          title: ''
        },
        user: {
          id: '',
          username: ''
        }
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    clear () {
      this.form = {
        id: '',
        rank1: '',
        rank2: '',
        content: '',
        watchDate: '',
        watchPlace: '',
        movie: '',
        user: ''
      }
    },
    onSubmit () {
      this.$axios
        .post('/reviews', {
          id: this.form.id,
          rank1: this.form.rank1,
          rank2: this.form.rank2,
          content: this.form.content,
          watchDate: this.form.watchDate,
          watchPlace: this.form.watchPlace,
          movie: this.form.movie,
          user: this.form.user
        }).then(resp => {
          if (resp && resp.status === 200) {
            this.dialogFormVisible = false
            this.$emit('onSubmit')
          }
        })
    }
  }
}
</script>

<style scoped>
.el-icon-circle-plus-outline {
  margin: 50px 0 0 20px;
  font-size: 100px;
  float: left;
  cursor: pointer;
}
</style>
