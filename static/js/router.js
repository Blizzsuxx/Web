import { createRouter, createWebHistory } from "https://unpkg.com/vue-router@next"
import test from '../app/test'
const routes = [
    {
      path: '../app/test',
      name: 'test',
      component: test,
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
  })

  export default router