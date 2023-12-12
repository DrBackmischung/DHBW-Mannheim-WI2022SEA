import * as dgram from 'dgram';
import * as readlineSync from 'readline-sync';

class MessageHeader {
    constructor(public date: string, public time: string, public status: string) {}
}

class MessageBody {
    constructor(public messages: string[], public status: string) {}
}

class Message {
    constructor(public header: MessageHeader, public body: MessageBody) {}
}

const server = dgram.createSocket('udp4');

server.on('message', (msg, rinfo) => {
    const receivedMessage: Message = JSON.parse(msg.toString());
    console.log('Received message:');
    console.log(`Date: ${receivedMessage.header.date}`);
    console.log(`Time: ${receivedMessage.header.time}`);
    console.log(`Status: ${receivedMessage.header.status}`);
    console.log(`Messages: ${receivedMessage.body.messages.join(', ')}`);

    // Log the message and send back acknowledgment
    receivedMessage.header.status = 'received';
    const acknowledgment: Message = receivedMessage;
    const acknowledgmentBuffer = Buffer.from(JSON.stringify(acknowledgment));
    server.send(acknowledgmentBuffer, rinfo.port, rinfo.address, (err) => {
        if (err) {
            console.error('Error sending acknowledgment:', err);
        } else {
            console.log('Acknowledgment sent back to client.');
        }
    });
});

server.bind(9876, 'localhost');

const client = dgram.createSocket('udp4');

const messagesToSend = ['Message 1', 'Message 2', 'Message 3'];

const header = new MessageHeader('2023-12-10', '12:34:56', 'sent');
const body = new MessageBody(messagesToSend, 'pending');

const messageToSend = new Message(header, body);

const messageBuffer = Buffer.from(JSON.stringify(messageToSend));

client.send(messageBuffer, 9876, 'localhost', (err) => {
    if (err) {
        console.error('Error sending message:', err);
    } else {
        console.log('Message sent to server.');
    }
});

client.on('message', (msg) => {
    const acknowledgment: Message = JSON.parse(msg.toString());
    console.log('Acknowledgment received:');
    console.log(`Date: ${acknowledgment.header.date}`);
    console.log(`Time: ${acknowledgment.header.time}`);
    console.log(`Status: ${acknowledgment.header.status}`);
    console.log(`Messages: ${acknowledgment.body.messages.join(', ')}`);
    client.close();
});
