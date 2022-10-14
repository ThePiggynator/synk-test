
// eslint-disable-next-line no-unused-vars
export class Game {
    id = 0;
    title;
    status;
    maxThinkTime;
    rated;
    createdAt;
    createdBy;


    constructor(id, title, status, maxThinkTime, rated, createdAt, createdBy) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.maxThinkTime = maxThinkTime;
        this.rated = rated;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
    static createSampleGame(pId){
        let id = pId;
        let title = "Sample game: " + Math.ceil(Math.random() * 10000);
        let status;
        let maxThinkTime = Math.floor(Math.random() * 100);
        let rated;
        let createdAt;
        let createdBy = "Hugo Blok";

        let randomNum = Math.floor(Math.random() * 4);
        switch (randomNum){
            case 0:
                status = "NEW"
                break
            case 1:
                status = "BROADCAST"
                break
            case 2:
                status = "RUNNING"
                break
            case 3:
                status = "FINISHED"
                break
        }

        randomNum = Math.floor(Math.random() * 2);
        switch (randomNum){
            case 0:
                rated = false;
                break
            case 1:
                rated = true;
                break
        }
        // get a random date within 31 days
        randomNum = Math.floor(Math.random() * 32);

        createdAt = new Date();
        createdAt.setDate(createdAt.getDate()-randomNum)

        return new Game(id, title, status, maxThinkTime, rated, createdAt, createdBy)
    }

    getId(){
        return this.id
    }
    getTitle(){
        return this.title
    }
    getCreatedAt(){
        let now = this.createdAt;
        let day = ("0" + now.getDate()).slice(-2);
        let month = ("0" + (now.getMonth() + 1)).slice(-2);
        let hour = ("0"+(now.getHours()+1)).slice(-2)
        let min = ("0"+(now.getMinutes()+1)).slice(-2)
        return now.getFullYear()+"-"+(month)+"-"+(day)+"T"+hour+":"+min
    }

    getStatus(){
        return this.status;
    }

    getRated(){
        return this.rated
    }
    getMaxThinkTime(){
        return this.maxThinkTime
    }

    static updateGame(oldGame, newGame){
        Object.assign(oldGame, newGame)
    }
    static copyConstructor(game){
       return new Game(
           game.id,
           game.title,
           game.status,
           game.maxThinkTime,
           game.rated,
           game.createdAt,
           game.createdBy,
       )
    }
    static gameHasChanges(oldGame, newGame){
        if (oldGame.title !== newGame.title) return true;
        if (oldGame.status !== newGame.status) return true;
        if (oldGame.maxThinkTime !== newGame.maxThinkTime) return true;
        if (oldGame.rated !== newGame.rated) return true;
        if (oldGame.createdAt !== newGame.createdAt) return true;


        return false;
    }
}

