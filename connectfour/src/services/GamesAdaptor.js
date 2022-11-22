// eslint-disable-next-line no-unused-vars
import {Game} from "@/models/Game";
import axiosImport from "axios";

export default class GamesAdaptor {
    axios;
    resourcesUrl;
    constructor(resourcesUrl) {
        this.resourcesUrl = resourcesUrl;
        this.axios = axiosImport.create({
            baseURL: resourcesUrl,
            timeout: 8000,
            headers: {'X-Custom-Header': 'foobar'}
        });
        console.log("Created games adaptor for: " + resourcesUrl);
    }
    async fetchJson(url, options = null){
        let res = await fetch(url, options);
        if (res.ok){
            return res.json();
        }
        else {
            console.log("Fetch failed")
            return null;
        }
    }

    async findAll(){

        // let res = await this.axios({
        //     method: 'GET',
        //     url: "",
        // })
        console.log("Finding all games...")
        let games = await this.fetchJson(this.resourcesUrl);
        return games?.map(Game.copyConstructor())
    }
    async findById(id){
        let res = await this.fetchJson(this.resourcesUrl + "/" + id);
        return res;
    }
    async saveGame(game){
        let res = this.axios({
            method: 'PUT',
            url: "/save",
            data: {
                id: game.id,
                title: game.title,
                status: game.status,
                maxThinkTime: game.maxThinkTime,
                rated : game.rated,
                createdAt: game.createdAt,
                createdBy: game.createdBy
            }
        })
        return res.data;
    }
    async deleteGame(id){
        let res = this.axios({
            method: 'DELETE',
            url: "/"+id,
        })
        return res.data;
    }
}