<template>
  <div class="gameContainer">
    <table>
      <tr>
        <th>Game Details</th>
        <th>( ID: {{  this.selectedGame.getId()  }} )</th>
      </tr>
      <tr>
        <th>Title:</th>
        <th><input id="titleInput" type="text" v-model="selectedGame.title"></th>
      </tr>
      <tr>
        <th>Status:</th>
        <th>
          <select id="statusInput" v-model="selectedGame.status">
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
          <input id="ratedInput" type="checkbox" v-model="selectedGame.rated">
        </th>
      </tr>
      <tr>
        <th>Max Thinking Time:</th>
        <th><input id="thinkTimeInput" type="number" v-model="selectedGame.maxThinkTime"></th>
      </tr>
      <tr>
        <th>Created at:</th>
        <th><input id="dateInput" type="datetime-local" v-model="selectedGame.createdAt"></th>
      </tr>
    </table><br>
    <button @click="deleteGame()">Delete Game</button>
  </div>
</template>

<script>
/* eslint-disable */
import {Game} from "@/models/Game";

export default {
  /* eslint-disable */
  name: "Detail32",
  props: [
      'selectedGame'
  ],
  emits: [
      'delete'
  ],
  data(){
    return{
    }
  },
  methods:{
    updateGame(){
      this.$emit('update')
    },
    deleteGame(){
      this.$emit('delete')
    },
  }
}
</script>

<style scoped>
.gameContainer {
  border: 1px solid #000;
}
</style>