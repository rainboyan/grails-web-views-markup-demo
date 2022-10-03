import org.grails.demo.Message

model {
    Message message
}
div(id: 'hello') {
    h1 message.title
    p message.body
}
