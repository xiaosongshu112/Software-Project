import Vue from "vue";
import VueRouter from "vue-router";
import Container from "./views/Container.vue";
import Login from "./views/Login";
import StudentCourse from "./views/student/StudentCourse";
import StudentInfo from "./views/student/StudentInfo";
import StudentTimeTable from "./views/student/StudentTimeTable";
import TeacherCourse from "./views/teacher/TeacherCourse";
import TeacherTimetable from "./views/teacher/TeacherTimetable";
import AdminDepartment from "./views/admin/AdminDepartment";
import AdminMajor from "./views/admin/AdminMajor";
import AdminTeacher from "./views/admin/AdminTeacher";
import AdminCourse from "./views/admin/AdminCourse";
import AdminAdmin from "./views/admin/AdminAdmin";
import Home from "./views/Home";

Vue.use(VueRouter);

//创建路由对象
const routes = [
    // 指定hash属性与组件对应关系
  {
    path: "/",
    name: "container",
    component: Container,
      children: [
      {
        path: "/student",
        name: "student-home",
        component: Home
      },
      {
        path: "/student/course",
        name: "student-course",
        component: StudentCourse
      },
      {
        path: "/student/timetable",
        name: "student-timetable",
        component: StudentTimeTable
      },
      {
        path: "/student/info",
        name: "student-info",
        component: StudentInfo
      },
      {
        path: "/teacher",
        name: "teacher-home",
        component: Home
      },
      {
        path: "/teacher/course",
        name: "teacher-course",
        component: TeacherCourse
      },
      {
        path: "/teacher/timetable",
        name: "teacher-timetable",
        component: TeacherTimetable
      },
      {
       path: "/admin",
       name: "admin-home",
       component: Home
      },
      {
        path: "/admin/department",
        name: "admin-department",
        component: AdminDepartment
      },
      {
        path: "/admin/major",
        name: "admin-major",
        component: AdminMajor
      },
      {
        path: "/admin/teacher",
        name: "admin-teacher",
        component: AdminTeacher
      },
      {
        path: "/admin/course",
        name: "admin-course",
        component: AdminCourse
      },
      {
        path: "/admin/admin",
        name: "admin-admin",
        component: AdminAdmin
      }
    ]
  },
  {
    path: "/login",
    name: "login",
    component: Login
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
