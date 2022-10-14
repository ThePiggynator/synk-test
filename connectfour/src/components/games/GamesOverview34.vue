<template>
  <div class="container">
    <div class="table">
      <table>
        <tr>
          <th>ID:</th>
          <th>Title:</th>
        </tr>
        <tbody>
        <template v-for="game in gameData" :key='game'>
          <tr v-on:click="select(game.id)" :id="game.id">
            <th>{{ game.id }}</th>
            <th>{{ game.title }}</th>
          </tr>
        </template>
        </tbody>
      </table>
      <button class="button" v-on:click="onNewGame">New game</button>
    </div>
    <template v-if="selectedGameId !== 0">
      <router-view @unselect="unselectEdit()" @delete="deleteGame()" :selected-game="selectedGame"/>
    </template>
    <template v-else>
      <h2>Select a game</h2>
    </template>
  </div>
</template>

<script>
import {Game} from '@/models/Game.js';

let lastId = 30000;
export default {
  name: "GamesOverview34",

  created() {
    for (let i = 0; i < 8; i++) {
      lastId += Math.ceil(Math.random() * 3)
      // eslint-disable-next-line
      this.gameData.push(Game.createSampleGame(lastId))
    }
  },
  methods: {
    async onNewGame() {
      lastId += Math.ceil(Math.random() * 3)
      // eslint-disable-next-line
      this.selectedGame = Game.createSampleGame(lastId)
      await this.gameData.push(this.selectedGame)
      this.select(this.selectedGame.getId())
    },
    select(id){
      if (id !== this.selectedGameId) {
        this.$router.push("/games/overview34/" + id)
        document.getElementById(id).style.background = "#42b983";
        if (this.hasGameSelected()) {
          document.getElementById(this.selectedGameId).style.background = "#ffffff";
        }
      } else {
        document.getElementById(this.selectedGameId).style.background = "#ffffff";
        this.selectedGameId = 0
        this.$router.push("/games/overview34")
      }
    },
    selectGame(gameId) {
      if (gameId !== this.selectedGameId) {
        this.selectedGameId = gameId;
        this.findGameById(gameId)
      }
      else {
        this.selectedGameId = 0;
        this.selectedGame = null;
      }
    },
    hasGameSelected() {
      return this.selectedGameId !== 0
    },
    deleteGame(){
      for (let i = 0; i < this.gameData.length; i++) {
        if (this.gameData[i].getId() === this.selectedGameId) {
          this.gameData.splice(i, 1)
        }
      }
      this.selectGame(this.selectedGameId)
    },
    findGameById(id){
      for (let i = 0; i < this.gameData.length; i++) {
        if (this.gameData[i].getId() === id) {
          // eslint-disable-next-line
          this.selectedGame = this.gameData[i]
        }
      }
    },
    unselectEdit(){
      document.getElementById(this.selectedGameId).style.background = "#ffffff";
      this.selectedGameId = 0
      this.selectedGame = null
      this.$router.push("/games/overview34")
    }
  },
  data() {
    return {
      gameData: [],
      selectedGame: Game,
      selectedGameId: 0,
    };
  },
  watch:{
    '$route'(){
      if (this.$route.params.id !== undefined) {
        this.selectGame(parseInt(this.$route.params.id))
      }
    }
  }
}
</script>

<style scoped>
.table {
  width: 40%;
}

table {
  border: 1px solid #000;
  width: 100%;

}

th {
  border: 1px solid #000;
}

.container {
  display: flex;
  justify-content: space-between;
}
a {
  text-decoration: none;
}
</style>