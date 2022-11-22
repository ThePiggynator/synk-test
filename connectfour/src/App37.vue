<template>
  <HeaderComponent/>
  <NavbarComponent/>
  <router-view/>
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue'
import NavbarComponent from './components/NavbarComponent.vue'
import GamesAdaptor from './services/GamesAdaptor.js'
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "App37",
  components: {
    HeaderComponent,
    NavbarComponent

  },
  provide(){
    return{
      gamesServices: new GamesAdaptor("http://localhost:8081/games")
    }
  }
}
</script>

<style scoped>

</style>