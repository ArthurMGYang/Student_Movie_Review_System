<template>
  <el-upload
    class="img-upload"
    ref="upload"
    action="http://localhost:8443/api/covers"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :before-remove="beforeRemove"
    :on-success="handleSuccess"
    multiple
    :limit="1"
    :on-exceed="handleExceed"
    :file-list="fileList">
    <el-button size="small" type="primary">upload</el-button>
    <div slot="tip" class="el-upload__tip">can only upload jpg/png files within 500kb</div>
  </el-upload>
</template>

<script>
export default {
  name: 'ImgUpload',
  data () {
    return {
      fileList: [],
      url: ''
    }
  },
  methods: {
    handleRemove (file, fileList) {
    },
    handlePreview (file) {
    },
    handleExceed (files, fileList) {
      this.$message.warning(`can only choose 1 file，${files.length} chosen，totally ${files.length + fileList.length} file(s)`)
    },
    beforeRemove (file, fileList) {
      return this.$confirm(`remove ${file.name}？`)
    },
    handleSuccess (response) {
      this.url = response
      this.$emit('onUpload')
      this.$message.warning('successfully uploaded')
    },
    clear () {
      this.$refs.upload.clearFiles()
    }
  }
}
</script>
