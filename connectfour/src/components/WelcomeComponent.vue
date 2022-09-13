<template>
  <div class="container">
    <div class="row">
      <div class="col-3">
        <h4>Pick a date: </h4>
        <input type="date" id="birthday" name="birthday">
        <br>
        <br>
        <h5><a href="">Link 1</a></h5>
        <h5><a href="">Link 2</a></h5>
        <h5><a href="">Link 3</a></h5>
        <h5><a href="">Link 4</a></h5>
      </div>
      <div class="col-6">
        <h4>Photo gallery: </h4>
        <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
        <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
        <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
        <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
        <img class="foto" alt="Vue logo" src="../assets/galleryPhoto.jpg">
      </div>
      <div class="col-3">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Egestas integer eget aliquet nibh praesent tristique. Arcu cursus euismod quis viverra nibh cras pulvinar mattis nunc. Urna id volutpat lacus laoreet non curabitur gravida arcu. Dui faucibus in ornare quam viverra. Vel orci porta non pulvinar neque laoreet. Et magnis dis parturient montes. Id semper risus in hendrerit gravida rutrum quisque. Ultricies integer quis auctor elit. Commodo elit at imperdiet dui accumsan sit amet nulla. Sed turpis tincidunt id aliquet risus feugiat in.
        <br><br>
        Aenean euismod elementum nisi quis eleifend quam adipiscing vitae proin. Eu turpis egestas pretium aenean pharetra magna. Ultrices in iaculis nunc sed augue. In hendrerit gravida rutrum quisque non tellus. Volutpat est velit egestas dui id ornare arcu odio ut. In est ante in nibh mauris cursus. Amet venenatis urna cursus eget nunc scelerisque viverra mauris. Interdum consectetur libero id faucibus. Quis auctor elit sed vulputate mi sit amet mauris commodo. Lacus sed viverra tellus in hac habitasse platea dictumst. Commodo ullamcorper a lacus vestibulum sed arcu non.</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "WelcomeComponent",
  data(){
    return{
      msg: "This is the Welcome component."
    }
  }
}
</script>

<style scoped>
.container{
}
.foto{
  padding: 5px;
  height: 150px;
}
.col-3{
  border-left: 1px solid #000;
  border-right: 1px solid #000;
}
</style>