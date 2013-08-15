package vdo

class Video {

	String title
	Date   postedDate = new Date() // now
	String url

	static hasMany = [comments: Comment]

    static constraints = {
    	url(size:0..1000)
    }
}
