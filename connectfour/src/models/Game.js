
// eslint-disable-next-line no-unused-vars
export class Game {
    id;
    title;
    status;
    maxThinkTime;
    rated;
    createdAt;
    createdBy;


    constructor(id, title, status, maxThinkTime, rated, createdAt, createdBy) {
        this._id = id;
        this._title = title;
        this._status = status;
        this._maxThinkTime = maxThinkTime;
        this._rated = rated;
        this._createdAt = createdAt;
        this._createdBy = createdBy;
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
        return this._id
    }
    getTitle(){
        return this._title
    }
    getCreatedAt(){
        let now = this._createdAt;
        let day = ("0" + now.getDate()).slice(-2);
        let month = ("0" + (now.getMonth() + 1)).slice(-2);
        let hour = ("0"+(now.getHours()+1)).slice(-2)
        let min = ("0"+(now.getMinutes()+1)).slice(-2)
        return now.getFullYear()+"-"+(month)+"-"+(day)+"T"+hour+":"+min
    }

    getStatus(){
        return this._status;
    }

    getRated(){
        return this._rated
    }
    getMaxThinkTime(){
        return this._maxThinkTime
    }

    updateGame(title, status, maxThinkTime, rated, createdAt){
        this._title = title;
        this._status = status;
        this._maxThinkTime = maxThinkTime;
        this._rated = rated;
        this._createdAt = new Date(createdAt);
    }
}
