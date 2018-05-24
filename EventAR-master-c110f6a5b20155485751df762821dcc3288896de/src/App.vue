<template>
  <div id="app" v-on:click="closeDropdowns">
    <Navigation/>
    <router-view/>
    <Footer/>
  </div>
</template>

<script>
import Navigation from '@/components/Navigation'
import Footer from '@/components/Footer'

export default {
  name: 'App',
  components: {
    Navigation,
    Footer
  },
  methods: {
    closeDropdowns: function (event) {
      if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName('dropdown-content')
        for (var i = 0; i < dropdowns.length; i++) {
          var openDropdown = dropdowns[i]
          if (openDropdown.classList.contains('show')) {
            openDropdown.classList.remove('show')
          }
        }
      }
    }
  }
}
</script>

<style>
body {
  padding: 0;
  margin: 0;
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
