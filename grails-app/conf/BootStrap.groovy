import vdo.Video

class BootStrap {

    def init = { servletContext ->
    	def v = new Video(
    		title:"Welcome",
    		url:"http://tech.mthai.com/wp-content/uploads/2011/04/google-youtube-logo.jpg"
    	)
    	v = v.save()
    	println v   	
    }

    def destroy = {
    }
}
