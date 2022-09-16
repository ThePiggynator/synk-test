
// eslint-disable-next-line no-unused-vars
class game {
    id;
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
    // eslint-disable-next-line no-unused-vars
    static createSampleGame(pId){
        let id = pId;
        let title = "Sample game: " + Math.floor(Math.random() * 1000);
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
        createdAt = new Date() - randomNum;

        return new game(id, title, status, maxThinkTime, rated, createdAt, createdBy)
    }
}