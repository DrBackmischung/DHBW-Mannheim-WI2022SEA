export class TopicsModel {
    constructor(name: string, description: string, done: boolean = false) {
        this.name = name;
        this.description = description;
        this.done = done;
    }
    name: string;
    description: string;
    done: boolean;    
}