<template>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <header>
    <div class="header">
<!--      <h1 class="">Heading</h1>-->
      <img class="foto" alt="Vue logo" src="../assets/logo.png" id="foto">

      <h4>4 op een rij</h4>
      <h5>Epic game</h5>
<!--      <a class="btn btn-primary" href="" role="button">Call to action</a>-->
    </div>
    <!-- Jumbotron -->
  </header>
</template>

<script>
export default {
  name: "HeaderComponent"
}
</script>

<style scoped>
.header{
  width: 100%;
  height: 125px;
  background-image: url("../assets/background.png");
  background-size: cover;
  color:white;
}
  .foto {
    height: 100px;
    float: left;
  }
</style>