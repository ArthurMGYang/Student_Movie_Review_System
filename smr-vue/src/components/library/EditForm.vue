<template>
  <div>
    <i class="el-icon-circle-plus-outline" @click="dialogFormVisible = true"></i>
    <el-dialog title="add movie" :visible.sync="dialogFormVisible" @close="clear">
      <el-form v-model="form" style = "text-align: left" ref="dataForm">
        <el-form-item label="title" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.title" autocomplete="off" placeholder="please input title"></el-input>
        </el-form-item>
        <el-form-item label="cover" :label-width="formLabelWidth" prop="cover">
          <el-input v-model="form.cover" autocomplete="off" placeholder="picture url"></el-input>
        </el-form-item>
        <el-form-item label="director" :label-width="formLabelWidth" prop="director">
          <el-input v-model="form.director" autocomplete="off"></el-input>
          <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
        </el-form-item>
        <el-form-item label="starring" :label-width="formLabelWidth" prop="starring">
          <el-input v-model="form.starring" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="date" :label-width="formLabelWidth" prop="date">
          <el-input v-model="form.date" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="public_resource" :label-width="formLabelWidth" prop="public_resource">
          <el-input v-model="form.public_resource" autocomplete="off" placeholder="public resource link if there is one"></el-input>
        </el-form-item>
        <el-form-item label="category" :label-width="formLabelWidth" prop="categoryID">
          <el-select v-model="form.category.id" placeholder="select one category">
            <el-option label="Cartoon" value="1"></el-option>
            <el-option label="Sci-fi movie" value="2"></el-option>
            <el-option label="Documentary" value="3"></el-option>
            <el-option label="Horror" value="4"></el-option>
            <el-option label="Comedy" value="5"></el-option>
            <el-option label="Romance" value="6"></el-option>
          </el-select>
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
import ImgUpload from './ImgUpload'
export default {
  name: 'EditForm',
  components: {ImgUpload},
  data () {
    return {
      dialogFormVisible: false,
      form: {
        id: '',
        cover: '',
        title: '',
        director: '',
        starring: '',
        date: '',
        public_resource: '',
        category: {
          id: '',
          name: ''
        }
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    clear () {
      this.form = {
        id: '',
        cover: '',
        title: '',
        director: '',
        starring: '',
        date: '',
        public_resource: '',
        category: ''
      }
    },
    onSubmit () {
      const username = JSON.parse(localStorage.getItem('user')).username
      if (username === 'admin') {
        this.$axios
          .post('/movies', {
            id: this.form.id,
            cover: this.form.cover,
            title: this.form.title,
            director: this.form.director,
            starring: this.form.starring,
            data: this.form.date,
            public_resource: this.form.public_resource,
            category: this.form.category
          }).then(resp => {
            if (resp && resp.status === 200) {
              this.dialogFormVisible = false
              this.$emit('onSubmit')
            }
          })
      } else {
        this.$message({
          type: 'info',
          message: 'cancel delete'
        })
      }
    },
    uploadImg () {
      this.form.cover = this.$refs.imgUpload.url
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
