<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-fixed-top sticky">
    <div class="container-fluid">
      <!-- Navbar Brand - Eventar -->
      <router-link tag="span"  to="/" exact>
        <a class="navbar-brand" href="#">EVENTAR</a>
      </router-link>

      <!-- Responsive navigation button -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
          <router-link tag="li" class="nav-item" to="/discover" exact>
            <a class="nav-link">Discover</a>
          </router-link>
          <router-link tag="li" class="nav-item" to="/plan" exact>
            <a class="nav-link">Plan</a>
          </router-link>
          <router-link tag="li" class="nav-item" to="/venue" exact>
            <a class="nav-link">Venues</a>
          </router-link>
          <router-link tag="li" class="nav-item" to="/vendors" exact>
            <a class="nav-link">Vendors</a>
          </router-link>
          <li v-if="isLogged" class="nav-item dropdown">
          <a  class="nav-link dropdown-toggle dropbtn" href="#" v-on:click="showProfileMenu">
            Profile
          </a>
          <div class="dropdown-menu dropdown-content" id="myDropdown" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Signed in as<br />{{username}}</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">My Events</a>
            <a class="dropdown-item" href="#">Favourites</a>
            <a class="dropdown-item" href="#">Board</a>
            <a class="dropdown-item" href="#">Calendar</a>
            <a class="dropdown-item" href="#">Favourites</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Settings</a>
            <a class="dropdown-item" v-on:click="signOut">Sign out</a>
          </div>
          <li v-else class="nav-item">
            <a class="nav-link" v-on:click="showModal">Sign in</a>
          </li>
          </li>
        </ul>
      </div>
    </div>
    <LoginModal />
  </nav>
</template>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<script>
import firebase from 'firebase'
import LoginModal from '@/components/LoginModal'
// import Modal from '@/components/Modal';

export default {
  name: 'Navigation',
  components: {
    LoginModal
  },
  data: function () {
    return {
      isLogged: false
    }
  },
  mounted () {
    firebase.auth().getRedirectResult().then(
  (result) => {
    // if (result.user != null)
    this.isLogged = firebase.auth().currentUser
    this.username = firebase.auth().currentUser && firebase.auth().currentUser.displayName
  },
error => {
  console.error(error)
  alert(error.message)
})
   /* firebase.auth().getRedirectResult().then(function (result) {
      this.isLogged = firebase.auth().currentUser
      this.username = firebase.auth().currentUser && firebase.auth().currentUser.displayName
          // console.log(result.user);
}.bind(this)).catch(function (error) {
  console.error(error)
  if (error.code === 'auth/account-exists-with-different-credential') {
     alert('failed login')
  }
})
    /* setInterval(function () {
      this.isLogged = firebase.auth().currentUser
      this.username = firebase.auth().currentUser && firebase.auth().currentUser.displayName
    }.bind(this), 50)*/
  },
  methods: {
    showModal () {
      this.$modal.show('LoginModal')
    },
    /* show (failedLogin) {
      this.failedLogin = failedLogin
      this.$nextTick(() => {
        this.$modal.show('LoginModal', { text: 'aaaa' })
      })
    },*/
    showProfileMenu () {
      document.getElementById('myDropdown').classList.toggle('show')
    },
    /**
     * Signout the currently logged-in user
     */
    signOut () {
      // Signout the user using firebase
      this.isLogged = false
      firebase.auth().signOut()
    }
  }
}

</script>

<style>
.bg-dark {
  background-color: #f8f9fa !important;
}

.navbar-light {
  color: rgba(0, 0, 0, 0.9);
  font-family: 'Poppins', sans-serif;
  font-weight: 600;
  text-transform: uppercase;
}

.sticky {
  z-index: 1;
  position: fixed;
  top: 0;
  width: 100%;
}

.navbar {
  padding: 1.5rem 1rem;
}

.navbar .navbar-brand {
  font-size: 40px;
  color: #FF5733;
  /* orange */
}

.navbar .navbar-brand:hover {
  color: #900c3f;
  /* purple */
}

.nav-item {
  padding-right: 5px;
}

.navbar-nav {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  -ms-flex-direction: column;
  flex-direction: column;
  margin-bottom: 0;
  list-style: none;
  padding-right: 60px;
}

.navbar-nav .nav-link {
  padding-right: 0;
  padding-left: 100;
  cursor: pointer;
}

</style>
