<template>
  <HeaderComponent/>
  <NavbarComponent/>
  <GamesOverview32/>
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue'
// import WelcomeComponent from './components/WelcomeComponent.vue'
import NavbarComponent from './components/NavbarComponent.vue'
// import GamesOverview31 from './components/games/GamesOverview31.vue'
import GamesOverview32 from './components/games/GamesOverview32.vue'

export default {
  name: 'AppThirtyOne',
  components: {
    HeaderComponent,
    NavbarComponent,
    GamesOverview32
    // WelcomeComponent

  }
}

</script>


<style scoped>

</style>