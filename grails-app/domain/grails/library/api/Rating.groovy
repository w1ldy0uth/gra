package grails.library.api

class Rating {

    int value
    int userId

    static belongsTo = [book: Book]
    static constraints = {
        value min: 1, max: 5
        userId unique: true
    }
}
