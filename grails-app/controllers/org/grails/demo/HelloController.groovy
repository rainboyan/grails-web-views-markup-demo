package org.grails.demo

import grails.web.mime.MimeUtility

class HelloController {
    MimeUtility grailsMimeUtility

    def index() {
        println 'MimeTypes: '
        grailsMimeUtility?.getKnownMimeTypes().each {
            println it
        }
        println 'request.format: ' + request.format

        withFormat {
            htmx {
                println 'htmx...'
                render(contentType: 'text/html', template: "/hello/index", model: [message: new Message(title: 'Grails Views', body: 'HTMx')])
            }
            html {
                println 'html...'
                respond new Message(title: 'Grails Views', body: 'GSP')
            }
            all {
                println 'all...'
                respond new Message(title: 'Grails Views', body: 'Grails')
            }
        }
    }
}
