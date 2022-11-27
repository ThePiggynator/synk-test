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
    async findAll() {

        console.log("Finding all games...")
        let array = [];
        let res = await this.axios({
            method: 'GET',
            url: ""
        })
        for (let i = 0; i < res.data.length; i++) {
            array.push(Game.copyConstructor(res.data[i]))
        }
        return array;
    }

    async findById(id) {
        let res = await this.axios({
            method: 'GET',
            url: "/"+id
        })
        return res.data;
    }

    async saveGame(game) {
        // let resttest = await fetch('/save', {
        //     method: 'PUT',
        //     body: {
        //
        //     }
        // })
        let res;
        if (game.id != 0) {
            res = await this.axios({
                method: 'PUT',
                url: "/" + game.id,
                data: {
                    id: game.id,
                    title: game.title,
                    status: game.status,
                    maxThinkTime: game.maxThinkTime,
                    rated: game.rated,
                    createdAt: game.createdAt,
                    createdBy: game.createdBy
                }
            })
        }
        else {
            res = await this.axios({
                method: 'POST',
                url: "/save",
                data: {
                    id: 0,
                    title: "",
                    status: "",
                    maxThinkTime: 0,
                    rated: false,
                    createdAt: "0-0-0000",
                    createdBy: ""
                }
            })
            return Game.copyConstructor(res.data)
        }
        console.log(res.data)
        return res.data;
    }

    async deleteGame(id) {
        let res = this.axios({
            method: 'DELETE',
            url: "/" + id,
        })
        return res.data;
    }
}