package vdo

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class IndexComposer extends GrailsComposer {

    def afterCompose = { window ->

    	// get data from database
    	// 1 record
    	def v = Video.findByTitle("Welcome")    	
    	$('#video')[0].src = v.url

    	def comments = Comment.findAllByVideo(v)
    	for(c in comments) {
    		$('#comments').append {
    			hbox {
					label(value: c.text, style:"background: silver")
					button(label:'x')
				}
     		}
    	}

    	$("button[label='x']").on('click', { 
    		alert('delete')
    	})


     	$('#btnComment').on('click',{

     		def comment = $('#txtComment')[0].text

     		def c = new Comment(
     			text:  comment,
     			video: v)
     		c.save()

     		$('#comments').append {
     			label(value: comment)
     		}

     		$('#txtComment')[0].text = ''

     	})
    }
}
