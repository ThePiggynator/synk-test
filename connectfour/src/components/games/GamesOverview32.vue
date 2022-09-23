<template>
  <table>
    <tr>
      <th>ID:</th>
      <th>Title:</th>
    </tr>
    <tbody>
    <template v-for="data in gameData" :key='data'>
      <tr v-on:click="selectGame(data.getId())" :id="data.getId()">
        <th>{{ data.getId() }}</th>
        <th>{{ data.getTitle() }}</th>
      </tr>
    </template>
    </tbody>
  </table>
  <button class="button" v-on:click="onNewGame">New game</button>

</template>

<script>
import {Game} from '@/models/Game.js';
let lastId = 30000;
// eslint-disable-next-line no-unused-vars
let selectedGame = null
export default {
  name: "GamesOverview32",

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
    selectGame(gameId){
      if (gameId != selectedGame){
        document.getElementById(gameId).style.background = "#42b983";
        if (selectedGame != null){
          document.getElementById(selectedGame).style.background = "#ffffff";
        }
        selectedGame = gameId;
      } else {
        console.log(selectedGame);
        document.getElementById(selectedGame).style.background = "#ffffff";
        selectedGame = null;
      }
    }
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
  width: 33%;

}

th {
  border: 1px solid #000;
}
</style>