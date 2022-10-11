<template>
  <div class="container">
    <div class="table">
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
    </div>
    <template v-if="selectedGameId !== 0">
      <detail32 @update="updateGame()" @delete="deleteGame()" :selected-game="this.selectedGame"/>
    </template>
    <template v-else>
      <h2>Select a game</h2>
    </template>
  </div>
</template>

<script>
import Detail32 from './Detail32.vue'
import {Game} from '@/models/Game.js';

let lastId = 30000;
export default {
  name: "GamesOverview32",

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
      this.selectGame(this.selectedGame.getId())
    },
    selectGame(gameId) {
      if (gameId !== this.selectedGameId) {
        document.getElementById(gameId).style.background = "#42b983";
        if (this.hasGameSelected()) {
          document.getElementById(this.selectedGameId).style.background = "#ffffff";
        }
        this.selectedGameId = gameId;
        for (let i = 0; i < this.gameData.length; i++) {
          if (this.gameData[i].getId() === gameId) {
            this.selectedGame = this.gameData[i]
          }
        }
      } else {
        document.getElementById(this.selectedGameId).style.background = "#ffffff";
        this.selectedGameId = 0;
        this.selectedGame = null;
      }
    },
    hasGameSelected() {
      return this.selectedGameId !== 0
    },
    updateGame(){
      const title = document.getElementById("titleInput").value
      const status = document.getElementById("statusInput").value
      const rated = document.getElementById("ratedInput").checked
      const thinkTime = document.getElementById("thinkTimeInput").value
      const date = document.getElementById("dateInput").value

      for (let i = 0; i < this.gameData.length; i++) {
        if (this.gameData[i].getId() === this.selectedGameId) {
          this.gameData[i].updateGame(title, status, thinkTime, rated, date)
        }
      }
    },
    deleteGame(){
      for (let i = 0; i < this.gameData.length; i++) {
        if (this.gameData[i].getId() === this.selectedGameId) {
          this.gameData.splice(i, 1)
        }
      }
      this.selectGame(this.selectedGameId)
    }
  },
  data() {
    return {
      gameData: [],
      selectedGame: Game,
      selectedGameId: 0,
    };
  },
  components: {
    Detail32
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
</style>