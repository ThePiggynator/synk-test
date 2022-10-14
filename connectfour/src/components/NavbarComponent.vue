<template>

  <ul class="navbarFlex">
    <div class="right">
      <li><router-link to="/home">Home</router-link></li>
      <li class="dropdown">
        <a class="dropbtn">Games</a>
        <div class="dropdown-content">
          <router-link to="/games/overview31">All games overview</router-link>
          <a href="#">Games details (comp)</a>
          <router-link to="/games/overview32">Edit games (3.2)</router-link>
          <router-link to="/games/overview33">Edit games (3.3)</router-link>
          <router-link to="/games/overview34">Edit games (3.4)</router-link>
        </div>
      </li>
      <li><a href="#">My account</a></li>
    </div>
    <div class="left">
      <li><router-link to="/login">Login</router-link></li>

      <li><router-link to="register">Signup</router-link></li>
    </div>
  </ul>
</template>

<script>
export default {
  name: "NavbarComponent"
}
</script>

<style scoped>
body {
  background-color:white;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #38444d;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1;}

.dropdown:hover .dropdown-content {
  display: block;
}
.navbarFlex{
  display: flex;
  justify-content:space-between;
  flex-wrap: wrap;
}
</style>