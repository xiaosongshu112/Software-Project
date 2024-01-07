<template>
  <div class="home-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-id-badge"></i> 首页
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      tableData: []
    };
  },
  methods: {
    query() {
    },
    openNews(url) {
      window.open(url, "_blank");
    }
  },
  created() {
    this.query();
  }
};
</script>

<style scoped>
.home-wrap {
  height: 100%;
  width: 100%;
}

.main-wrap {
  margin-top: 10px;
  height: 100%;
  width: 100%;
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.home-container {
  height: 100%;
  width: 90%;
  margin: auto;
}
</style>
