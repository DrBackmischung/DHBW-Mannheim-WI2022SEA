import { TopicsModel } from "./model";

export class TopicsView {
    display(topics: TopicsModel[]) {
        console.log('=========================================================')
        for (const topic of topics) {
            console.log(`${topic.name}: ${topic.description}`);
            console.log(`Status: ${topic.done ? 'Done' : 'To Do'}`);
            console.log('=========================================================')
        }
    }
}