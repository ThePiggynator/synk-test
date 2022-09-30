<template>
  <HeaderComponent/>
  <NavbarComponent/>
  <router-view/>
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue'
import NavbarComponent from './components/NavbarComponent.vue'
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "App33",
  components: {
    HeaderComponent,
    NavbarComponent

  }
}
</script>

<style scoped>

</style>