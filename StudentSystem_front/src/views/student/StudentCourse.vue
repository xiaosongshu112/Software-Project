<template>
  <div class="course-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-fa fa-edit"></i> 学生课程
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="container">
      <div class="table">
        <el-table :data="tableData" stripe>
          <el-table-column label="选课Id" prop="studentCourseId" />
          <el-table-column label="课程名" prop="courseName" />
          <el-table-column label="教师" prop="teacherName" />
          <el-table-column align="center" label="操作" width="200px">
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import * as api from "../../api/student/course";

export default {
  name: "StudentCourse",
  data() {
    return {
      tableData: []
    };
  },
  methods: {
    getList() {
      api.list().then(res => {
        this.tableData = res;
      });
    },
  },
  created() {
    this.getList();
  }
};
</script>

<style scoped></style>
