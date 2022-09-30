<template>
  <div class="gameContainer">
    <table>
      <tr>
        <th>Game Details</th>
        <th>( ID: {{  this.selectedGame.getId()  }} )</th>
      </tr>
      <tr>
        <th>Title:</th>
        <th><input id="titleInput" type="text" :value="this.selectedGame.getTitle()"></th>
      </tr>
      <tr>
        <th>Status:</th>
        <th>
          <select id="statusInput" :value="this.selectedGame.getStatus()">
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
          <input id="ratedInput" type="checkbox" v-if="this.selectedGame.getRated()" checked>
          <input id="ratedInput" type="checkbox" v-else>
        </th>
      </tr>
      <tr>
        <th>Max Thinking Time:</th>
        <th><input id="thinkTimeInput" type="number" :value="this.selectedGame.getMaxThinkTime()"></th>
      </tr>
      <tr>
        <th>Created at:</th>
        <th><input id="dateInput" type="datetime-local" :value="this.selectedGame.getCreatedAt()"></th>
      </tr>
    </table><br>
    <button @click="updateGame()">Update / save</button><br>
    <button @click="deleteGame()">Delete Game</button>
  </div>
</template>

<script>
/* eslint-disable */
import {Game} from "@/models/Game";

export default {
  /* eslint-disable */
  name: "Detail33",
  props: [
    'selectedGame'
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
    }
  }
}
</script>

<style scoped>
.gameContainer {
  border: 1px solid #000;
}
</style>