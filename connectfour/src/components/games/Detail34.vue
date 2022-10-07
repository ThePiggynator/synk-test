<template>
  <div className="gameContainer">
    <table>
      <tr>
        <th>Game Details</th>
        <th>( ID: {{ this.newGame.getId() }} )</th>
      </tr>
      <tr>
        <th>Title:</th>
        <!--eslint-disable-->
          <th><input id="titleInput" type="text" v-model="newGame.title"></th>
      </tr>
      <tr>
        <th>Status:</th>
        <th>
          <select id="statusInput" v-model="newGame.status">
            <option value="NEW">NEW</option>
            <option value="BROADCAST">BROADCAST</option>
            <option value="RUNNING">RUNNING</option>
            <option value="FINISHED">FINISHED</option>
          </select>
        </th>
      </tr>
      <tr>
        <th>Rated:</th>
        <th>
          <input id="ratedInput" type="checkbox" v-model="newGame.rated">
        </th>
      </tr>
      <tr>
        <th>Max Thinking Time:</th>
        <th><input id="thinkTimeInput" type="number" v-model="newGame.maxThinkTime"></th>
      </tr>
      <tr>
        <th>Created at:</th>
        <th><input id="dateInput" type="datetime-local" v-model="newGame.createdAt"></th>
      </tr>
    </table>
    <br>
    <div class="buttons">
      <button v-if="gameHasChanges()" @click="deleteGame()" disabled>Delete Game</button>
      <button v-else @click="deleteGame()">Delete Game</button>

      <button v-if="!gameHasChanges()" @click="resetGame()" disabled>Reset Game</button>
      <button v-else @click="resetGame()">Reset Game</button>

      <button v-if="!gameHasChanges()" @click="saveGame()" disabled>Save Game</button>
      <button v-else @click="saveGame()">Save Game</button>

      <button @click="clearGame()">Clear Game</button>

      <button @click="cancelGame()">Cancel Game</button>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import {Game} from "@/models/Game";

export default {
  /* eslint-disable */
  name: "Detail34",
  props: [
    'selectedGame'
  ],
  data() {
    return {
      newGame: Game,
      hasChanged: Boolean
    }
  },
  methods: {
    saveGame() {
      this.selectedGame.updateGame(this.newGame)
      this.$emit('unselect')
    },
    clearGame(){
      this.newGame.title = null
      this.newGame.status = null
      this.newGame.rated = null
      this.newGame.maxThinkTime = null
      this.newGame.createdAt = null
    },
    deleteGame() {
      this.$emit('delete')
    },
    resetGame(){
      this.newGame = Game.copyConstructor(this.selectedGame)
    },
    cancelGame(){
      this.$emit('unselect')
    },
    gameHasChanges(){
      if (this.newGame.title !== this.selectedGame.title){
        this.hasChanged = true
        return this.hasChanged;
      }
      if (this.newGame.status !== this.selectedGame.status){
        this.hasChanged = true
        return this.hasChanged;
      }
      if (this.newGame.rated !== this.selectedGame.rated){
        this.hasChanged = true
        return this.hasChanged;
      }
      if (this.newGame.maxThinkTime !== this.selectedGame.maxThinkTime){
        this.hasChanged = true
        return this.hasChanged;
      }
      if (this.newGame.createdAt !== this.selectedGame.createdAt){
        this.hasChanged = true
        return this.hasChanged;
      }
      this.hasChanged = false
      return this.hasChanged;
    }
  },
  created() {
    this.newGame = Game.copyConstructor(this.selectedGame)
  },
  watch:{
    selectedGame(val, oldVal){
      if (val !== oldVal) {
        this.newGame = Game.copyConstructor(this.selectedGame)
      }
    },
  }
}
</script>

<style scoped>
.gameContainer {
  border: 1px solid #000;
}
</style>