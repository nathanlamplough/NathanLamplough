<template>
  <div class="main">
    <Grid/>
    <QuickSearch/>
    <Packages/>
  </div>
</template>

<script>
import Grid from '@/components/Grid'
import QuickSearch from '@/components/QuickSearch'
import Packages from '@/components/Packages'

export default {
  name: 'Main',
  data () {
    return {
    }
  },
  components: {
    Grid,
    QuickSearch,
    Packages,
    'icon': require('vue-icons')
  }
}
</script>

<style scoped>
  .main {
  }
</style>
