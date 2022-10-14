<template>
  <HeaderComponent/>
  <NavbarComponent/>
  <GamesOverview32/>
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue'
import NavbarComponent from './components/NavbarComponent.vue'
import GamesOverview32 from './components/games/GamesOverview32.vue'

export default {
  name: 'AppThirtyTwo',
  components: {
    HeaderComponent,
    NavbarComponent,
    GamesOverview32

  }
}

</script>


<style scoped>

</style>