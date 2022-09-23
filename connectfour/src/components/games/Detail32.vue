<template>
  <div class="gameContainer">
    <table>
      <tr>
        <th>Game Details</th>
        <th>(Id: )</th>
      </tr>
      <tr>
        <th>Title:</th>
        <th><input type="text"></th>
      </tr>
      <tr>
        <th>Status:</th>
        <th><input type="text"></th>
      </tr>
      <tr>
        <th>Rated:</th>
        <th><input type="text"></th>
      </tr>
      <tr>
        <th>Max Thinking Time:</th>
        <th><input type="text"></th>
      </tr>
      <tr>
        <th>Created at:</th>
        <th><input type="date"></th>
      </tr>
    </table>
  </div>
</template>

<script>

import {Game} from "@/models/Game";

export default {
  /* eslint-disable */
  name: "Detail32",
  props: {
    selectedGame: Game
  }
}
</script>

<style scoped>
.gameContainer {
  border: 1px solid #000;
}
</style>