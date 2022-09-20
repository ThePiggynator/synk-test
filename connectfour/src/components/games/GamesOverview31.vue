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
          <th>{{data.getId()}}</th>
          <th>{{data.getTitle()}}</th>
          <th>{{data.getCreatedAt()}}</th>
          <th>{{data.getStatus()}}</th>
          <th>{{data.getRated()}}</th>
          <th>{{data.getMaxThinkTime()}}</th>
        </tr>
      </template>
      </tbody>

    </table>
</template>

<script>
import { Game } from '@/models/Game.js';

export default {
  name: "GamesOverview31",
  created() {
    let lastId = 30000;

    for (let i = 0; i < 8; i++) {
      lastId += Math.ceil(Math.random() * 3)
      this.gameData.push(Game.createSampleGame(lastId))
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
  table{
    border: 1px solid #000;
    width: 100%;
  }
  th{
    border-left: 1px solid #000;
    border-right: 1px solid #000;
  }
</style>