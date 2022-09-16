<template>
  <header>
    <div class="header">
      <div class="left">
        <!--      <h1 class="">Heading</h1>-->
        <img class="foto" alt="Vue logo" src="../assets/logo.png" id="foto">
        <div class="headerText>">
          <h4>4 op een rij</h4>
          <h5>Epic game</h5>
        </div>
      </div>
      <div class="right">
        <br><br>
        <h4>Today is: {{ date }}</h4>
      </div>
      <!--      <a class="btn btn-primary" href="" role="button">Call to action</a>-->
    </div>
    <!-- Jumbotron -->
  </header>
</template>

<script>
export default {
  name: "HeaderComponent",
  data() {
    return {
      date: new Date().toDateString(),
    }
  }
}
</script>

<style scoped>
.header {
  width: 100%;
  height: 125px;
  display: flex;
  justify-content: space-between;
  background-image: url("../assets/background.png");
  background-size: cover;
  color: white;
}

h4 {
  margin-top: 0;
}

.left{
  display: flex;
}

.foto {
  height: 100px;
  float: left;
}
</style>