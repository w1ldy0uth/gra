package grails.library.api

class Book {

    String title
    String author
    String coverImageUrl
    int publicationYear
    String description
    Float averageRating = 0.0

    static hasMany = [ratings: Rating]
    static constraints = {
        title blank: false, maxSize: 255
        author blank: false, maxSize: 255
        coverImageUrl nullable: true, maxSize: 512
        publicationYear min: 1000, max: 9999
        description nullable: true, maxSize: 1000
    }
}
