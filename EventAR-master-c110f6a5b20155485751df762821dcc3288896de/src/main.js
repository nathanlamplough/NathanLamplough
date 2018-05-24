// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import VModal from 'vue-js-modal'
import firebase from 'firebase'

Vue.config.productionTip = false

Vue.use(VModal)

let config = {
  apiKey: 'AIzaSyAM6m8CYZEqvFOoSFK2YgutsBVvK_srohY',
  authDomain: 'eventar-85053.firebaseapp.com',
  databaseURL: 'https://eventar-85053.firebaseio.com',
  projectId: 'eventar-85053',
  storageBucket: 'eventar-85053.appspot.com',
  messagingSenderId: '504742948038'
}
firebase.initializeApp(config)

/* firebase.auth().getRedirectResult().then(function (result) {
          // console.log(result.user);
}).catch(function (error) {
  console.error(error)
  // if (error.code == "auth/account-exists-with-different-credential") {
    // alert('failed login')
  // }
})

// create the app instance.
// here we inject the router to all child components,
// making it available everywhere as `this.$router`.
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
