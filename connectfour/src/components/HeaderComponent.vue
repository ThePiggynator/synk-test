<template>
  <header>
    <h1>{{ msg }}</h1>
  </header>
</template>

<script>
export default {
  name: "HeaderComponent",
  data(){
    return{
      msg: "This is the Header component."
    }
  }
}
</script>

<style scoped>

</style>