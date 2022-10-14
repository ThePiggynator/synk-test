<template>
  <div class="container">
    <div class="left">
      <h4>Pick a date: </h4>
      <input type="date" id="birthday" name="birthday">
      <br>
      <br>
      <h5><a href="">Link 1</a></h5>
      <h5><a href="">Link 2</a></h5>
      <h5><a href="">Link 3</a></h5>
      <h5><a href="">Link 4</a></h5>
    </div>
    <div class="center">
      <h4>Photo gallery: </h4>
      <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
      <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
      <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
      <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
      <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
    </div>
    <div class="right">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
      labore et dolore magna aliqua. Egestas integer eget aliquet nibh praesent tristique. Arcu cursus euismod quis
      viverra nibh cras pulvinar mattis nunc. Urna id volutpat lacus laoreet non curabitur gravida arcu. Dui faucibus in
      ornare quam viverra. Vel orci porta non pulvinar neque laoreet. Et magnis dis parturient montes. Id semper risus
      in hendrerit gravida rutrum quisque. Ultricies integer quis auctor elit. Commodo elit at imperdiet dui accumsan
      sit amet nulla. Sed turpis tincidunt id aliquet risus feugiat in.
      <br><br>
      Aenean euismod elementum nisi quis eleifend quam adipiscing vitae proin. Eu turpis egestas pretium aenean pharetra
      magna. Ultrices in iaculis nunc sed augue. In hendrerit gravida rutrum quisque non tellus. Volutpat est velit
      egestas dui id ornare arcu odio ut. In est ante in nibh mauris cursus. Amet venenatis urna cursus eget nunc
      scelerisque viverra mauris. Interdum consectetur libero id faucibus. Quis auctor elit sed vulputate mi sit amet
      mauris commodo. Lacus sed viverra tellus in hac habitasse platea dictumst. Commodo ullamcorper a lacus vestibulum
      sed arcu non.
    </div>
  </div>
</template>

<script>
export default {
  name: "WelcomeComponent",
  data() {
    return {
      msg: "This is the Welcome component."
    }
  }
}
</script>

<style scoped>
.container {
  margin-left: 0;
  margin-right: 0;
  display: flex;
  flex-wrap: wrap;
  background-image: url("../assets/pacmanbackground.jpg") ;
  min-height: 82.4vh;
  background-size: contain;
  color: white;
}

.foto {
  padding: 5px;
  height: 150px;
}

.center {
  border-left: 1px solid white;
  border-right: 1px solid white;
  width: 50%;
  padding-left: 10px;
  padding-right: 10px;
}
.left ,.right {
  padding: 5px;
  width: 22%;
}
.left{
  padding-left: 10px;
}
.right{
  padding-right: 10px;

}
</style>