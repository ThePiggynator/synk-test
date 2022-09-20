<template>
  <HeaderComponent/>
  <NavbarComponent/>
  <GamesOverview31/>
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue'
// import WelcomeComponent from './components/WelcomeComponent.vue'
import NavbarComponent from './components/NavbarComponent.vue'
import GamesOverview31 from './components/games/GamesOverview31.vue'

export default {
  name: 'AppThirtyOne',
  components: {
    HeaderComponent,
    NavbarComponent,
    GamesOverview31
    // WelcomeComponent

  }
}

</script>


<style scoped>

</style>