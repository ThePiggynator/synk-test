<template>
  <table>
    <tr>
      <th>ID:</th>
      <th>Title:</th>
      <th>Created at:</th>
      <th>Status:</th>
      <th>Rated:</th>
      <th>Max think Time:</th>
    </tr>
    <tbody>
    <template v-for="data in gameData" :key='data'>
      <tr>
        <th>{{ data.getId() }}</th>
        <th>{{ data.getTitle() }}</th>
        <th>{{ data.getCreatedAt() }}</th>
        <th>{{ data.getStatus() }}</th>
        <th>{{ data.getRated() }}</th>
        <th>{{ data.getMaxThinkTime() }}</th>
      </tr>
    </template>
    </tbody>
  </table>
  <button class="button" v-on:click="onNewGame">New game</button>
</template>

<script>
import {Game} from '@/models/Game.js';
let lastId = 30000;
export default {
  name: "GamesOverview31",
  created() {
    for (let i = 0; i < 8; i++) {
      lastId += Math.ceil(Math.random() * 3)
      this.gameData.push(Game.createSampleGame(lastId))
    }
  },
  methods: {
    onNewGame() {
      lastId += Math.ceil(Math.random() * 3)
      this.gameData.push(Game.createSampleGame(lastId))
    },
  },
  data() {
    return {
      gameData: [],
    };
  },

}
</script>

<style scoped>
table {
  border: 1px solid #000;
  width: 100%;
}

th {
  border: 1px solid #000;
}
</style>