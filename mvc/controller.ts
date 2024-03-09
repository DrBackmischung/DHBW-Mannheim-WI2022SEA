import { TopicsModel } from "./model";
import { TopicsView } from "./view";

export class TopicsController {
    private model: TopicsModel[];
    private view: TopicsView;

    constructor(model: TopicsModel[], view: TopicsView) {
        this.model = model;
        this.view = view;
    }

    addTopic(name: string, description: string) {
        const newTopic = new TopicsModel(name, description);
        this.model.push(newTopic);
        this.view.display(this.model);
    }

    completeTask(name: string) {
        const topic = this.model.find(topic => topic.name === name);
        if(topic) {
            topic.done = true;
        }
        this.view.display(this.model);
    }
}