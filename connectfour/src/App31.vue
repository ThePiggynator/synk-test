<template>
  <HeaderComponent/>
  <NavbarComponent/>
  <WelcomeComponent/>
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue'
import WelcomeComponent from './components/WelcomeComponent.vue'
import NavbarComponent from './components/NavbarComponent.vue'

export default {
  name: 'AppThirtyOne',
  components: {
    HeaderComponent,
    NavbarComponent,
    WelcomeComponent
  }
}

</script>


<style scoped>

</style>