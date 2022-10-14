<template>
  <header>
    <div class="header">
      <div class="left">
        <!--      <h1 class="">Heading</h1>-->
        <div class="headerText">
          <h1>Connect Four</h1>
          <h2>Pacman Edition</h2>
        </div>
      </div>
      <div class="right">
        <h4>Today is: {{ date }}</h4>
        <img class="foto" alt="Pacman gif" src="../assets/pacmanload.gif" id="foto">
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
  background-image: url("../assets/banner.png");
  background-size: contain;
  background-repeat: no-repeat;
  background-position: center;
}

h4 {
  margin-top: 0;
}

.left{
  display: flex;
}

.foto {
  height: 100px;
  margin-right: 30px;
  float: right;
}

.right {
  width: 20%;
  display: flex;
  flex-wrap: nowrap;
}

.headerText {
  padding-left: 10px;
  flex-wrap: wrap;
}
</style>