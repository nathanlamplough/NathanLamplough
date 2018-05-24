import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Discover from '@/components/Discover'
import Plan from '@/components/Plan'
import Venue from '@/components/Venue'
import Developers from '@/components/Developers'
import Vendors from '@/components/Vendors'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/discover',
      name: 'Discover',
      component: Discover
    },
    {
      path: '/plan',
      name: 'Plan',
      component: Plan
    },
    {
      path: '/venue',
      name: 'Venue',
      component: Venue
    },
    {
      path: '/developers',
      name: 'Developers',
      component: Developers
    },
    {
      path: '/vendors',
      name: 'Vendors',
      component: Vendors
    }
  ]
})
